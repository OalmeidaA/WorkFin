package com.GMHDigital.API_WorkFin.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GMHDigital.API_WorkFin.DTO.CarteiraTrabalhoDTO;
import com.GMHDigital.API_WorkFin.services.CarteiraTrabalhoService;

@RestController
@RequestMapping(value = "/CarteiraTrabalho")
public class CarteiraTrabalhoController {

	@Autowired
	private CarteiraTrabalhoService service;

	@PostMapping
	public ResponseEntity<CarteiraTrabalhoDTO> insert(@RequestBody CarteiraTrabalhoDTO dto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(service.insert(dto));
	}
}
