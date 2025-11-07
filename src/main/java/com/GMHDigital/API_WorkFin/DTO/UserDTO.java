package com.GMHDigital.API_WorkFin.DTO;

import java.time.LocalDate;

import com.GMHDigital.API_WorkFin.entities.User;

public class UserDTO {
	
	private Long id;
	private String nome;
	private String email;
	private Integer idade;
	private String profissao;
	private Integer salarioBruto;
	private Integer salarioLiquido;
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private Boolean feriasVencidas;

	public UserDTO() {
	}

	public UserDTO(Long id, String nome, String email, Integer idade, String profissao, Integer salarioBruto,
			Integer salarioLiquido, LocalDate dataInicio, LocalDate dataFinal, Boolean feriasVencidas) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.profissao = profissao;
		this.salarioBruto = salarioBruto;
		this.salarioLiquido = salarioLiquido;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.feriasVencidas = feriasVencidas;
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

	public Integer getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(Integer salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public Integer getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(Integer salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Boolean getFeriasVencidas() {
		return feriasVencidas;
	}

	public void setFeriasVencidas(Boolean feriasVencidas) {
		this.feriasVencidas = feriasVencidas;
	}
	
}
