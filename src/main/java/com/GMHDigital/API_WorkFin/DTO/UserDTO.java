package com.GMHDigital.API_WorkFin.DTO;

import com.GMHDigital.API_WorkFin.entities.User;

public class UserDTO {
	
	private Long id;
	private String nome;
	private String email;
	private Integer idade;
	private String profissao;

	public UserDTO() {
	}

	public UserDTO(Long id, String nome, String email, Integer idade, String profissao) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.profissao = profissao;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
		idade = entity.getIdade();
		profissao = entity.getProfissao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

}
