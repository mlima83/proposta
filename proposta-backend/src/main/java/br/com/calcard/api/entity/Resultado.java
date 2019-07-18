package br.com.calcard.api.entity;

/**
 * 
 * @author marco
 *
 */
public enum Resultado {
	
	APROVADO("Aprovado"),
	NEGADO("Negado"),
	INCONCLUSIVO("Inconclusivo");

	private String label;
	
	private Resultado(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
