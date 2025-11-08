package com.GMHDigital.API_WorkFin.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GMHDigital.API_WorkFin.DTO.ContaDTO;
import com.GMHDigital.API_WorkFin.entities.Conta;
import com.GMHDigital.API_WorkFin.entities.User;
import com.GMHDigital.API_WorkFin.repositories.ContaRepository;
import com.GMHDigital.API_WorkFin.repositories.UserRepository;

@Service
public class ContaService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContaRepository contaRepository;

	@Transactional
	public ContaDTO insert(ContaDTO dto) {
		User user = userRepository.findById(dto.getUserId())
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado para criar conta!"));

		Conta conta = new Conta(dto, user);
		contaRepository.save(conta);
		return new ContaDTO(conta);
	}
	
	@Transactional(readOnly = true)
	public List<ContaDTO> findAll(){
		List<Conta> listConta = contaRepository.findAll();
		List<ContaDTO> listContaDTO = listConta.stream().map(x -> new ContaDTO(x)).collect(Collectors.toList());
		return listContaDTO;
	}
}
