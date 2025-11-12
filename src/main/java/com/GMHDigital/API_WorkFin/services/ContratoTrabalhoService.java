package com.GMHDigital.API_WorkFin.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GMHDigital.API_WorkFin.DTO.ContratoTrabalhoDTO;
import com.GMHDigital.API_WorkFin.entities.CarteiraTrabalho;
import com.GMHDigital.API_WorkFin.entities.ContratoTrabalho;
import com.GMHDigital.API_WorkFin.repositories.CarteiraTrabalhoRepository;
import com.GMHDigital.API_WorkFin.repositories.ContratoTrabalhoRepository;

@Service
public class ContratoTrabalhoService {

	@Autowired
	private ContratoTrabalhoRepository contratoRepository;
	
	@Autowired
	private CarteiraTrabalhoRepository carteiraRepository;

	@Transactional
	public ContratoTrabalhoDTO insert(ContratoTrabalhoDTO dto) {

		CarteiraTrabalho carteira = carteiraRepository.getReferenceById(dto.getCarteiraTrabalhoId());
		ContratoTrabalho contrato = new ContratoTrabalho(dto, carteira);
		contratoRepository.save(contrato);
		carteira.getContratos().add(contrato);
		return new ContratoTrabalhoDTO(contrato);
	}

	@Transactional(readOnly = true)
	public List<ContratoTrabalhoDTO> findAll() {
		List<ContratoTrabalho> list = contratoRepository.findAll();
		List<ContratoTrabalhoDTO> listDTO = list.stream().map(x -> new ContratoTrabalhoDTO(x))
				.collect(Collectors.toList());
		return listDTO;
	}

}
