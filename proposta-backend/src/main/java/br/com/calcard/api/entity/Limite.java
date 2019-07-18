package br.com.calcard.api.entity;

/**
 * 
 * @author marco
 *
 */
public enum Limite {
	LIMITE_100_500("Entre 100 - 500"),
	LIMITE_500_1000("Entre 500 - 1000"),
	LIMITE_1000_1500("Entre 1000 - 1500"),
	LIMITE_1500_2000("Entre 1500 - 2000"),
	REPROVADO("Reprovado pela política de crédito"),
	SUPERIOR_2000("Superior a 2000"),
	RENDA_BAIXA("Renda baixa"),
	INCONCLUSIVO("Inconclusivo");
	
	private String label;
	
	private Limite(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
