package br.com.calcard.api.dto;

import java.io.Serializable;

import br.com.calcard.api.entity.Cliente;
import br.com.calcard.api.entity.Proposta;

/**
 * Proposta DTO de resposta
 * @author Marco
 *
 */
public class PropostaResponse implements Serializable{

	private Cliente cliente;
	
	private String resultado;
	
	private String limite;
	
	public PropostaResponse() {}
	public PropostaResponse(Proposta proposta) {
		cliente = proposta.getCliente();
		if(proposta.getResultadoAnalise() != null)
			resultado = proposta.getResultadoAnalise().getLabel();
		if(proposta.getLimiteAprovado() != null)
			limite = proposta.getLimiteAprovado().getLabel();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getLimite() {
		return limite;
	}

	public void setLimite(String limite) {
		this.limite = limite;
	}

}
