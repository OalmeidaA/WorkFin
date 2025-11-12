package com.GMHDigital.API_WorkFin.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GMHDigital.API_WorkFin.DTO.CarteiraTrabalhoDTO;
import com.GMHDigital.API_WorkFin.entities.CarteiraTrabalho;
import com.GMHDigital.API_WorkFin.entities.User;
import com.GMHDigital.API_WorkFin.repositories.CarteiraTrabalhoRepository;
import com.GMHDigital.API_WorkFin.repositories.UserRepository;

@Service
public class CarteiraTrabalhoService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CarteiraTrabalhoRepository carteiraRepository;
	
	@Transactional
	public CarteiraTrabalhoDTO insert(CarteiraTrabalhoDTO dto) {

		User user = userRepository.getReferenceById(dto.getUserId());
		CarteiraTrabalho carteiraTrabalho = new CarteiraTrabalho(dto, user);
		carteiraRepository.save(carteiraTrabalho);
		return new CarteiraTrabalhoDTO(carteiraTrabalho);
	}
	
	@Transactional(readOnly = true)
	public List<CarteiraTrabalhoDTO> findAll() {
		List<CarteiraTrabalho> list = carteiraRepository.findAll();
		List<CarteiraTrabalhoDTO> listDTO = list.stream().map(x -> new CarteiraTrabalhoDTO(x)).collect(Collectors.toList());
		return listDTO;
	}

}
