package com.GMHDigital.API_WorkFin.DTO;

import com.GMHDigital.API_WorkFin.entities.Conta;

import jakarta.persistence.Column;

public class ContaDTO {

	private Long id;
	private int saldoTotal;
	
	@Column(unique = true)
	private long userId;
	
	public ContaDTO() {
		
	}

	public ContaDTO(Long id, int saldoTotal, long userId) {
		super();
		this.id = id;
		this.saldoTotal = saldoTotal;
		this.userId = userId;
	}
	
	public ContaDTO(Conta entity) {
		id = entity.getId();
		saldoTotal = entity.getSaldoTotal();
		userId = entity.getUser().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(int saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
