package com.GMHDigital.API_WorkFin.services;

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
}
