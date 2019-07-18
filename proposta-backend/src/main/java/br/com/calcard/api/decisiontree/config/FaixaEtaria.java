package br.com.calcard.api.decisiontree.config;

public enum FaixaEtaria {
	MENOR_18(),
	DE_18_30(),
	DE_30_60(),
	MAIOR_60();
	
	public static FaixaEtaria idenfificar(int idade) {
		if(idade < 18)
			return MENOR_18;
		if(idade >= 18 && idade <=30)
			return DE_18_30;
		if(idade > 30 && idade <=60)
			return DE_30_60;
		return MAIOR_60;
	}
}
