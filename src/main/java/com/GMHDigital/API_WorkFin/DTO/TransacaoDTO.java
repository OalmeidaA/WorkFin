package com.GMHDigital.API_WorkFin.DTO;

import java.time.LocalDate;

import com.GMHDigital.API_WorkFin.entities.Categoria;
import com.GMHDigital.API_WorkFin.entities.TipoTransacao;
import com.GMHDigital.API_WorkFin.entities.Transacao;

public class TransacaoDTO {

	private Long id;
	private Integer valor;
	private LocalDate data;
	private String descricao;

	private TipoTransacao tipoTransacao;
	private Categoria categoria;

	private Long userId;
	private Long contaId;
	
	public TransacaoDTO() {
		
	}
	
	public TransacaoDTO(Transacao entity) {
		id = entity.getId();
		valor = entity.getValor();
		data = entity.getData();
		descricao = entity.getDescricao();
		tipoTransacao = entity.getTipoTransacao();
		categoria = entity.getCategoria();
		setUserId(entity.getUser().getId());
		setContaId(entity.getConta().getId());
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


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getContaId() {
		return contaId;
	}

	public void setContaId(Long contaId) {
		this.contaId = contaId;
	}
	
	
}
