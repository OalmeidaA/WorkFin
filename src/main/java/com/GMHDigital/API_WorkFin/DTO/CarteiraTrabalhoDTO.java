package com.GMHDigital.API_WorkFin.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.GMHDigital.API_WorkFin.entities.CarteiraTrabalho;

import jakarta.persistence.Column;

public class CarteiraTrabalhoDTO {

	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	
	@Column(unique = true)
	private String email;
	
	private String enderecoResidencia;
	private String estado;
	
	private Long userId;
	
	private List<ContratoTrabalhoDTO> contratos = new ArrayList<>();
	
	public CarteiraTrabalhoDTO() {
	}

	public CarteiraTrabalhoDTO(Long id, String nome, LocalDate dataNascimento, String email, String enderecoResidencia,
			String estado, Long userId, List<ContratoTrabalhoDTO> contratos) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.enderecoResidencia = enderecoResidencia;
		this.estado = estado;
		this.userId = userId;
		this.contratos = contratos;
	}
	
	public CarteiraTrabalhoDTO(CarteiraTrabalho entity) {
		id = entity.getId();
		nome = entity.getNome();
		dataNascimento = entity.getDataNascimento();
		email = entity.getEmail();
		enderecoResidencia = entity.getEnderecoResidencia();
		estado = entity.getEstado();
		userId = entity.getUser().getId();
		
		if(entity.getContratos() != null) {
			this.contratos = entity.getContratos().stream().map(x -> new ContratoTrabalhoDTO()).collect(Collectors.toList());
		} else {
			this.contratos = null;
		}
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnderecoResidencia() {
		return enderecoResidencia;
	}

	public void setEnderecoResidencia(String enderecoResidencia) {
		this.enderecoResidencia = enderecoResidencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<ContratoTrabalhoDTO> getContratos() {
		return contratos;
	}

	public void setContratos(List<ContratoTrabalhoDTO> contratos) {
		this.contratos = contratos;
	}

}
