package br.com.calcard.api.entity;

public enum EstadoCivil {
	SOLTEIRO("Solteiro(a)"),
	DIVORCIADO("Divorciado(a)"),
	VIUVO("Viúvo(a)"),
	CASADO("Casado(a)");

	private String label;
	
	private EstadoCivil(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
