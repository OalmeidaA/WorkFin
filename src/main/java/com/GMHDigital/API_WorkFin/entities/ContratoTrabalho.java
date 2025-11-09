package com.GMHDigital.API_WorkFin.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Contrato_trabalho")
public class ContratoTrabalho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String empresa;
	private String cargo;
	
	@Enumerated(EnumType.STRING)
	private TipoContrato tipoContrato;
	
	private Integer salarioBruto;
	private Integer salarioLiquido;
	
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	
	private Boolean feriasVencidas;
	
	@Enumerated(EnumType.STRING)
	private TipoAdicionais adicionais;
	

	public ContratoTrabalho() {
		
	}

	public ContratoTrabalho(Long id, String empresa, String cargo, TipoContrato tipoContrato, Integer salarioBruto,
			Integer salarioLiquido, LocalDate dataInicio, LocalDate dataFinal, Boolean feriasVencidas,
			TipoAdicionais adicionais) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.cargo = cargo;
		this.tipoContrato = tipoContrato;
		this.salarioBruto = salarioBruto;
		this.salarioLiquido = salarioLiquido;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.feriasVencidas = feriasVencidas;
		this.adicionais = adicionais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
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

	public TipoAdicionais getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(TipoAdicionais adicionais) {
		this.adicionais = adicionais;
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
		ContratoTrabalho other = (ContratoTrabalho) obj;
		return Objects.equals(id, other.id);
	}
	
}
