package com.GMHDigital.API_WorkFin.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer saldoTotal;
	
	@OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Transacao> transacoes = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	public Conta() {	
	}
	
	
	public Conta(Long id, Integer saldoTotal, List<Transacao> transacoes) {
		super();
		this.id = id;
		this.saldoTotal = saldoTotal;
		this.transacoes = transacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(Integer saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
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
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}
	
}
