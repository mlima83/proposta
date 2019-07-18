package br.com.calcard.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.calcard.api.dto.PropostaRequest;

/**
 * Proposta
 * @author Marco
 *
 */
@Entity
public class Proposta implements Serializable{

	@Id @GeneratedValue
	private Long id;
	private Long renda;
	@ManyToOne
	private Cliente cliente;
	@Enumerated(EnumType.STRING)
	private Resultado resultadoAnalise;
	@Enumerated(EnumType.STRING)
	private Limite limiteAprovado; 
	
	public Proposta() {}

	public Proposta(Long id) {
		setId(id);
	}

	public Proposta(PropostaRequest propostaRequest) {
		this.renda = propostaRequest.getRenda();
		this.cliente = propostaRequest.getCliente();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRenda() {
		return renda;
	}

	public void setRenda(Long renda) {
		this.renda = renda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Resultado getResultadoAnalise() {
		return resultadoAnalise;
	}

	public void setResultadoAnalise(Resultado resultadoAnalise) {
		this.resultadoAnalise = resultadoAnalise;
	}

	public Limite getLimiteAprovado() {
		return limiteAprovado;
	}

	public void setLimiteAprovado(Limite limiteAprovado) {
		this.limiteAprovado = limiteAprovado;
	}


}
