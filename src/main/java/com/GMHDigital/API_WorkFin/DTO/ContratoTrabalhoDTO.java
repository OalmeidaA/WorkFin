package com.GMHDigital.API_WorkFin.DTO;

import java.time.LocalDate;

import com.GMHDigital.API_WorkFin.entities.ContratoTrabalho;
import com.GMHDigital.API_WorkFin.entities.TipoAdicionais;
import com.GMHDigital.API_WorkFin.entities.TipoContrato;

import jakarta.persistence.Column;

public class ContratoTrabalhoDTO {

	private Long id;

	private String empresa;
	private String cargo;
	private TipoContrato tipoContrato;

	private Integer salarioBruto;
	private Integer salarioLiquido;

	private LocalDate dataInicio;
	private LocalDate dataFinal;

	private Boolean feriasVencidas;

	private TipoAdicionais adicionais;

	@Column(unique = true)
	private Long carteiraTrabalhoId;
	
	public ContratoTrabalhoDTO() {
		
	}

	public ContratoTrabalhoDTO(Long id, String empresa, String cargo, TipoContrato tipoContrato, Integer salarioBruto,
			Integer salarioLiquido, LocalDate dataInicio, LocalDate dataFinal, Boolean feriasVencidas,
			TipoAdicionais adicionais, Long carteiraTrabalhoId) {
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
		this.carteiraTrabalhoId = carteiraTrabalhoId;
	}
	
	ContratoTrabalhoDTO(ContratoTrabalho entity){
		id = entity.getId();
		empresa = entity.getEmpresa();
		cargo = entity.getCargo();
		tipoContrato = entity.getTipoContrato();
		salarioBruto = entity.getSalarioBruto();
		salarioLiquido = entity.getSalarioLiquido();
		dataInicio = entity.getDataInicio();
		dataFinal = entity.getDataFinal();
		feriasVencidas = entity.getFeriasVencidas();
		adicionais = entity.getAdicionais();
		carteiraTrabalhoId = entity.getCarteiraTrabalho().getId();
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

	public Long getCarteiraTrabalhoId() {
		return carteiraTrabalhoId;
	}

	public void setCarteiraTrabalhoId(Long carteiraTrabalhoId) {
		this.carteiraTrabalhoId = carteiraTrabalhoId;
	}
}
