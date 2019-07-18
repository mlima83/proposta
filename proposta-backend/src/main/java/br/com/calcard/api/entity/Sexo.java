package br.com.calcard.api.entity;

/**
 * 
 * @author marco
 *
 */
public enum Sexo {
	
	M("Masculino"),
	F("Feminino");

	private String label;
	
	private Sexo(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
