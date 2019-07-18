package br.com.calcard.api.dto;

import java.io.Serializable;

import br.com.calcard.api.entity.Cliente;
import br.com.calcard.api.entity.Proposta;

/**
 * Proposta DTO
 * @author Marco
 *
 */
public class PropostaRequest implements Serializable{

	private Long renda;
	private Cliente cliente;
	
	public PropostaRequest() {}
	
	public PropostaRequest(Proposta proposta) {
		this.renda = proposta.getRenda();
		this.cliente = proposta.getCliente();
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

	public Proposta getProposta() {
		return new Proposta(this);
	}

}
