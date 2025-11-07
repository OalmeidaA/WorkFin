package com.GMHDigital.API_WorkFin.entities;

import java.time.LocalDate;
import java.util.Objects;

import com.GMHDigital.API_WorkFin.DTO.TransacaoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transacoes")
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer valor;
	private LocalDate data;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private TipoTransacao tipoTransacao;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;
	
	public Transacao() {
	}

	public Transacao(Long id, Integer valor, LocalDate data, String descricao, TipoTransacao tipoTransacao,
			Categoria categoria) {
		super();
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.descricao = descricao;
		this.tipoTransacao = tipoTransacao;
		this.categoria = categoria;
	}

	public Transacao(TransacaoDTO dto, User user, Conta conta) {
		id = dto.getId();
		valor = dto.getValor();
		data = dto.getData();
		descricao = dto.getDescricao();
		tipoTransacao = dto.getTipoTransacao();
		categoria = dto.getCategoria();
		this.user = user;
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
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
		Transacao other = (Transacao) obj;
		return Objects.equals(id, other.id);
	}

}
