package br.com.calcard.api.dto;

import java.io.Serializable;

import br.com.calcard.api.entity.Estado;

public class EstadoResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public EstadoResponse() {}
	public EstadoResponse(Estado estado) {
		this.id = estado.name();
		this.nome = estado.getLabel();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
