package br.com.calcard.api.decisiontree.config;

import br.com.calcard.api.decisiontree.DataSet;
import br.com.calcard.api.decisiontree.DecisionTree;
import br.com.calcard.api.decisiontree.Record;
import br.com.calcard.api.entity.EstadoCivil;
import br.com.calcard.api.entity.Limite;
import br.com.calcard.api.entity.Resultado;

public class Teste {

	public static void main(String[] args) {
		Record reg;
		DataSet datasetLimite = new DataSet();
	
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.SOLTEIRO.toString());
		reg.add("DEPENDENTES", "nao");
		reg.add("IDADE", FaixaEtaria.idenfificar(28).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(2500L).toString());
		//reg.add("RESULTADO", Resultado.APROVADO.toString());
		reg.add("LIMITE", Limite.LIMITE_500_1000.toString());
		datasetLimite.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.SOLTEIRO.toString());
		reg.add("DEPENDENTES", "nao");
		reg.add("IDADE", FaixaEtaria.idenfificar(17).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(1000L).toString());
		//reg.add("RESULTADO", Resultado.APROVADO.toString());
		reg.add("LIMITE", Limite.LIMITE_100_500.toString());
		datasetLimite.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.CASADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(68).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(8000L).toString());
		//reg.add("RESULTADO", Resultado.APROVADO.toString());
		reg.add("LIMITE", Limite.LIMITE_1500_2000.toString());
		datasetLimite.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.CASADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(61).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(5000L).toString());
		//reg.add("RESULTADO", Resultado.APROVADO.toString());
		reg.add("LIMITE", Limite.LIMITE_1000_1500.toString());
		datasetLimite.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.DIVORCIADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(56).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(2000L).toString());
		//reg.add("RESULTADO", Resultado.NEGADO.toString());
		reg.add("LIMITE", Limite.REPROVADO.toString());
		datasetLimite.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.DIVORCIADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(45).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(2000L).toString());
		//reg.add("RESULTADO", Resultado.NEGADO.toString());
		reg.add("LIMITE", Limite.REPROVADO.toString());
		datasetLimite.add(reg);		
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.CASADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(30).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(8000L).toString());
		//reg.add("RESULTADO", Resultado.APROVADO.toString());
		reg.add("LIMITE", Limite.SUPERIOR_2000.toString());
		datasetLimite.add(reg);				
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.CASADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(33).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(10000L).toString());
		//reg.add("RESULTADO", Resultado.APROVADO.toString());
		reg.add("LIMITE", Limite.SUPERIOR_2000.toString());
		datasetLimite.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.SOLTEIRO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(19).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(400L).toString());
		//reg.add("RESULTADO", Resultado.NEGADO.toString());
		reg.add("LIMITE", Limite.RENDA_BAIXA.toString());
		datasetLimite.add(reg);		
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.VIUVO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(63).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(1500L).toString());
		//reg.add("RESULTADO", Resultado.NEGADO.toString());
		reg.add("LIMITE", Limite.REPROVADO.toString());
		datasetLimite.add(reg);	
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.SOLTEIRO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(28).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(2500L).toString());
		//reg.add("RESULTADO", Resultado.APROVADO.toString());
		reg.add("LIMITE", Limite.LIMITE_100_500.toString());
		datasetLimite.add(reg);		
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.SOLTEIRO.toString());
		reg.add("DEPENDENTES", "nao");
		reg.add("IDADE", FaixaEtaria.idenfificar(16).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(500L).toString());
		//reg.add("RESULTADO", Resultado.NEGADO.toString());
		reg.add("LIMITE", Limite.RENDA_BAIXA.toString());
		datasetLimite.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.CASADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(30).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(8000L).toString());
		//reg.add("RESULTADO", Resultado.APROVADO.toString());
		reg.add("LIMITE", Limite.LIMITE_1000_1500.toString());
		datasetLimite.add(reg);	
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.DIVORCIADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(33).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(5500L).toString());
		//reg.add("RESULTADO", Resultado.APROVADO.toString());
		reg.add("LIMITE", Limite.SUPERIOR_2000.toString());
		datasetLimite.add(reg);		
		
		// Definindo o atributo que queremos usar como classe
		datasetLimite.setAtributoDeClasse("LIMITE");
		

		DataSet datasetResultado = new DataSet();
	
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.SOLTEIRO.toString());
		reg.add("DEPENDENTES", "nao");
		reg.add("IDADE", FaixaEtaria.idenfificar(28).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(2500L).toString());
		reg.add("RESULTADO", Resultado.APROVADO.toString());
		//reg.add("LIMITE", Limite.LIMITE_500_1000.toString());
		datasetResultado.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.SOLTEIRO.toString());
		reg.add("DEPENDENTES", "nao");
		reg.add("IDADE", FaixaEtaria.idenfificar(17).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(1000L).toString());
		reg.add("RESULTADO", Resultado.APROVADO.toString());
		//reg.add("LIMITE", Limite.LIMITE_100_500.toString());
		datasetResultado.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.CASADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(68).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(8000L).toString());
		reg.add("RESULTADO", Resultado.APROVADO.toString());
		//reg.add("LIMITE", Limite.LIMITE_1500_2000.toString());
		datasetResultado.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.CASADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(61).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(5000L).toString());
		reg.add("RESULTADO", Resultado.APROVADO.toString());
		//reg.add("LIMITE", Limite.LIMITE_1000_1500.toString());
		datasetResultado.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.DIVORCIADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(56).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(2000L).toString());
		reg.add("RESULTADO", Resultado.NEGADO.toString());
		//reg.add("LIMITE", Limite.REPROVADO.toString());
		datasetResultado.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.DIVORCIADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(45).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(2000L).toString());
		reg.add("RESULTADO", Resultado.NEGADO.toString());
		//reg.add("LIMITE", Limite.REPROVADO.toString());
		datasetResultado.add(reg);		
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.CASADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(30).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(8000L).toString());
		reg.add("RESULTADO", Resultado.APROVADO.toString());
		//reg.add("LIMITE", Limite.SUPERIOR_2000.toString());
		datasetResultado.add(reg);				
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.CASADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(33).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(10000L).toString());
		reg.add("RESULTADO", Resultado.APROVADO.toString());
		//reg.add("LIMITE", Limite.SUPERIOR_2000.toString());
		datasetResultado.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.SOLTEIRO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(19).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(400L).toString());
		reg.add("RESULTADO", Resultado.NEGADO.toString());
		//reg.add("LIMITE", Limite.RENDA_BAIXA.toString());
		datasetResultado.add(reg);		
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.VIUVO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(63).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(1500L).toString());
		reg.add("RESULTADO", Resultado.NEGADO.toString());
		//reg.add("LIMITE", Limite.REPROVADO.toString());
		datasetResultado.add(reg);	
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.SOLTEIRO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(28).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(2500L).toString());
		reg.add("RESULTADO", Resultado.APROVADO.toString());
		//reg.add("LIMITE", Limite.LIMITE_100_500.toString());
		datasetResultado.add(reg);		
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.SOLTEIRO.toString());
		reg.add("DEPENDENTES", "nao");
		reg.add("IDADE", FaixaEtaria.idenfificar(16).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(500L).toString());
		reg.add("RESULTADO", Resultado.NEGADO.toString());
		//reg.add("LIMITE", Limite.RENDA_BAIXA.toString());
		datasetResultado.add(reg);
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.CASADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(30).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(8000L).toString());
		reg.add("RESULTADO", Resultado.APROVADO.toString());
		//reg.add("LIMITE", Limite.LIMITE_1000_1500.toString());
		datasetResultado.add(reg);	
		
		reg = new Record();
		reg.add("ESTADO_CIVIL", EstadoCivil.DIVORCIADO.toString());
		reg.add("DEPENDENTES", "sim");
		reg.add("IDADE", FaixaEtaria.idenfificar(33).toString());
		reg.add("RENDA", FaixaSalarial.idenfificar(5500L).toString());
		reg.add("RESULTADO", Resultado.APROVADO.toString());
		//reg.add("LIMITE", Limite.SUPERIOR_2000.toString());
		datasetResultado.add(reg);		
		
		// Definindo o atributo que queremos usar como classe
		datasetResultado.setAtributoDeClasse("RESULTADO");
		
		// Criando e construindo a rvore de deciso usando como base de treino
		// o conjunto de dados representado pelo objeto dataset.
		DecisionTree arvDecisao = new DecisionTree();
		arvDecisao.construir(datasetResultado);
		
		// Exibindo a rvore de Deciso aps a sua construo
		System.out.println("--:: Arvore de Deciso para esse conjunto de dados RESULTADO ::--");
		System.out.println(arvDecisao);
		
		// Vamos criar um novo registro para ver qual seria a sua classificao
		Record registro = new Record();
		registro.add("ESTADO_CIVIL", EstadoCivil.DIVORCIADO.toString());
		registro.add("DEPENDENTES", "sim");
		registro.add("IDADE", FaixaEtaria.idenfificar(45).toString());
		registro.add("RENDA", FaixaSalarial.idenfificar(2000L).toString());
		
		// Classificando o novo caso
		System.out.println("Nestas condies:");
		System.out.println(registro);
		System.out.println("Ser que ele foi aprovado?");
		System.out.println("E a resposta Resultado : " + arvDecisao.getClassificacao(registro) );
		System.out.println("--:: Arvore de Deciso para esse conjunto de dados LIMITE ::--");
		System.out.println(arvDecisao);
		arvDecisao.construir(datasetLimite);
		System.out.println("E a resposta Limite : " + arvDecisao.getClassificacao(registro) );
		// The life can't be more easy Padawan, all data load was automated!
		// May the force be with you! :)
		System.exit(0);
	}

}
