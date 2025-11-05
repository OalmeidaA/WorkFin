package com.GMHDigital.API_WorkFin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GMHDigital.API_WorkFin.DTO.TransacaoDTO;
import com.GMHDigital.API_WorkFin.entities.Transacao;
import com.GMHDigital.API_WorkFin.entities.User;
import com.GMHDigital.API_WorkFin.repositories.TransacaoRepository;
import com.GMHDigital.API_WorkFin.repositories.UserRepository;

@Service
public class TransacaoService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransacaoRepository transacaoRepository;

	public TransacaoDTO insert(TransacaoDTO dto) {
		User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		Transacao transacao = new Transacao(dto, user);
		transacaoRepository.save(transacao);
		return new TransacaoDTO(transacao);
	}
}
