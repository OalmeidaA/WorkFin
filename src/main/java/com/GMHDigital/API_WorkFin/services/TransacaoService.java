package com.GMHDigital.API_WorkFin.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GMHDigital.API_WorkFin.DTO.TransacaoDTO;
import com.GMHDigital.API_WorkFin.entities.Conta;
import com.GMHDigital.API_WorkFin.entities.TipoTransacao;
import com.GMHDigital.API_WorkFin.entities.Transacao;
import com.GMHDigital.API_WorkFin.entities.User;
import com.GMHDigital.API_WorkFin.repositories.ContaRepository;
import com.GMHDigital.API_WorkFin.repositories.TransacaoRepository;
import com.GMHDigital.API_WorkFin.repositories.UserRepository;

@Service
public class TransacaoService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private ContaRepository contaRepository;

	@Transactional
	public TransacaoDTO insert(TransacaoDTO dto) {
		User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		Conta conta = contaRepository.getReferenceById(dto.getContaId());
		
		Transacao transacao = new Transacao(dto, user, conta);
		
		if(dto.getTipoTransacao() == TipoTransacao.RECEITA) {
			conta.somaSaldoTotal(dto.getValor());
		} else if(dto.getTipoTransacao() == TipoTransacao.DESPESA) {
			conta.subtrairSaldoTotal(dto.getValor());
		}
		
		transacaoRepository.save(transacao);
		return new TransacaoDTO(transacao);
	}
	
	@Transactional(readOnly = true)
	public List<TransacaoDTO> findAll() {
		List<Transacao> list = transacaoRepository.findAll();
		List<TransacaoDTO> listDTO = list.stream().map(x -> new TransacaoDTO(x)).collect(Collectors.toList());
		return listDTO;
	}
}
