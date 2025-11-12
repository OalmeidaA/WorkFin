package com.GMHDigital.API_WorkFin.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.GMHDigital.API_WorkFin.DTO.CarteiraTrabalhoDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carteira_trabalho")
public class CarteiraTrabalho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private LocalDate dataNascimento;
	private String email;
	private String enderecoResidencia;
	private String estado;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "carteiraTrabalho", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ContratoTrabalho> contratos = new ArrayList<>();
	
	public CarteiraTrabalho() {
	}

	public CarteiraTrabalho(Long id, String nome, LocalDate dataNascimento, String email, String enderecoResidencia,
			String estado, User user, List<ContratoTrabalho> contratos ) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.enderecoResidencia = enderecoResidencia;
		this.estado = estado;
		this.user = user;
		this.contratos = contratos;
	}
	
	public CarteiraTrabalho(CarteiraTrabalhoDTO dto, User user) {
		id = dto.getId();
		nome = dto.getNome();
		dataNascimento = dto.getDataNascimento();
		email = dto.getEmail();
		enderecoResidencia = dto.getEnderecoResidencia();
		estado = dto.getEstado();
		this.user = user;
		contratos = dto.getContratos().stream().map(x -> new ContratoTrabalho()).collect(Collectors.toList());
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<ContratoTrabalho> getContratos() {
		return contratos;
	}

	public void setContratos(List<ContratoTrabalho> contratos) {
		this.contratos = contratos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarteiraTrabalho other = (CarteiraTrabalho) obj;
		return Objects.equals(id, other.id);
	}

}
