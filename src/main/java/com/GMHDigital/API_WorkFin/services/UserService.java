package com.GMHDigital.API_WorkFin.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GMHDigital.API_WorkFin.DTO.UserDTO;
import com.GMHDigital.API_WorkFin.entities.User;
import com.GMHDigital.API_WorkFin.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User user = new User(dto);
		userRepository.save(user);
		return new UserDTO(user);
	}
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll(){
		List<User> userList = userRepository.findAll();
		List<UserDTO> listDTO = userList.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return listDTO;
	}
	
}
