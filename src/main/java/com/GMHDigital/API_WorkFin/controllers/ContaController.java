package com.GMHDigital.API_WorkFin.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GMHDigital.API_WorkFin.DTO.ContaDTO;
import com.GMHDigital.API_WorkFin.services.ContaService;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

	@Autowired
	private ContaService contaService;
	
	@PostMapping
	public ResponseEntity<ContaDTO> insert(@RequestBody ContaDTO dto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(contaService.insert(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<ContaDTO>> findAll(){
		return ResponseEntity.ok().body(contaService.findAll());
	}

}
