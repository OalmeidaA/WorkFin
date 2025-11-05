package com.GMHDigital.API_WorkFin.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GMHDigital.API_WorkFin.DTO.TransacaoDTO;
import com.GMHDigital.API_WorkFin.services.TransacaoService;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {
	
	@Autowired
	private TransacaoService service;

	@PostMapping
	public ResponseEntity<TransacaoDTO> insert(@RequestBody TransacaoDTO dto) {
		TransacaoDTO transacao = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri(); 
		return ResponseEntity.created(uri).body(transacao);
	}
}
