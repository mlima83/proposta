package br.com.calcard.api.decisiontree.config;

public enum FaixaSalarial {
	MENOR_1000(),
	DE_1000_2500(),
	DE_2500_5000(),
	DE_5000_8000(),
	MAIOR_8000();
	
	public static FaixaSalarial idenfificar(Long salario) {
		if(salario < 1000)
			return MENOR_1000;
		if(salario >= 1000 && salario <=2500)
			return DE_1000_2500;
		if(salario > 2500 && salario <=5000)
			return DE_2500_5000;
		if(salario > 5000 && salario <=8000)
			return DE_5000_8000;
		return MAIOR_8000;
	}
}
