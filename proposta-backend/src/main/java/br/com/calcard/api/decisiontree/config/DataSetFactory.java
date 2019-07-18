package br.com.calcard.api.decisiontree.config;

import br.com.calcard.api.decisiontree.DataSet;
import br.com.calcard.api.decisiontree.Record;
import br.com.calcard.api.entity.EstadoCivil;
import br.com.calcard.api.entity.Limite;
import br.com.calcard.api.entity.Resultado;

public class DataSetFactory {
	
	public static final String ESTADO_CIVIL = "ESTADO_CIVIL";
	public static final String DEPENDENTES = "DEPENDENTES";
	public static final String IDADE = "IDADE";
	public static final String RENDA = "RENDA";	
	public static final String RESULTADO = "RESULTADO";	
	public static final String LIMITE = "LIMITE";	
	
	private static DataSetFactory instance;
	
	private DataSet dataSetResultado;
	
	private DataSet dataSetLimite;

	public static DataSetFactory getInstance() {
		if(instance == null)
			instance = new DataSetFactory();
		return instance;
	}

	public DataSet getDataSetResultado() {
		if(dataSetResultado == null) {
			Record reg;
			DataSet dataset = new DataSet();
		
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.SOLTEIRO.toString());
			reg.add(DEPENDENTES, "0");
			reg.add(IDADE, FaixaEtaria.idenfificar(28).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(2500L).toString());
			reg.add(RESULTADO, Resultado.APROVADO.toString());
			//reg.add(LIMITE, Limite.LIMITE_500_1000.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.SOLTEIRO.toString());
			reg.add(DEPENDENTES, "0");
			reg.add(IDADE, FaixaEtaria.idenfificar(17).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(1000L).toString());
			reg.add(RESULTADO, Resultado.APROVADO.toString());
			//reg.add(LIMITE, Limite.LIMITE_100_500.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.CASADO.toString());
			reg.add(DEPENDENTES, "3");
			reg.add(IDADE, FaixaEtaria.idenfificar(68).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(8000L).toString());
			reg.add(RESULTADO, Resultado.APROVADO.toString());
			//reg.add(LIMITE, Limite.LIMITE_1500_2000.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.CASADO.toString());
			reg.add(DEPENDENTES, "3");
			reg.add(IDADE, FaixaEtaria.idenfificar(61).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(5000L).toString());
			reg.add(RESULTADO, Resultado.APROVADO.toString());
			//reg.add(LIMITE, Limite.LIMITE_1000_1500.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.DIVORCIADO.toString());
			reg.add(DEPENDENTES, "2");
			reg.add(IDADE, FaixaEtaria.idenfificar(56).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(2000L).toString());
			reg.add(RESULTADO, Resultado.NEGADO.toString());
			//reg.add(LIMITE, Limite.REPROVADO.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.DIVORCIADO.toString());
			reg.add(DEPENDENTES, "1");
			reg.add(IDADE, FaixaEtaria.idenfificar(45).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(2000L).toString());
			reg.add(RESULTADO, Resultado.NEGADO.toString());
			//reg.add(LIMITE, Limite.REPROVADO.toString());
			dataset.add(reg);		
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.CASADO.toString());
			reg.add(DEPENDENTES, "2");
			reg.add(IDADE, FaixaEtaria.idenfificar(30).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(8000L).toString());
			reg.add(RESULTADO, Resultado.APROVADO.toString());
			//reg.add(LIMITE, Limite.SUPERIOR_2000.toString());
			dataset.add(reg);				
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.CASADO.toString());
			reg.add(DEPENDENTES, "1");
			reg.add(IDADE, FaixaEtaria.idenfificar(33).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(10000L).toString());
			reg.add(RESULTADO, Resultado.APROVADO.toString());
			//reg.add(LIMITE, Limite.SUPERIOR_2000.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.SOLTEIRO.toString());
			reg.add(DEPENDENTES, "1");
			reg.add(IDADE, FaixaEtaria.idenfificar(19).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(400L).toString());
			reg.add(RESULTADO, Resultado.NEGADO.toString());
			//reg.add(LIMITE, Limite.RENDA_BAIXA.toString());
			dataset.add(reg);		
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.VIUVO.toString());
			reg.add(DEPENDENTES, "3");
			reg.add(IDADE, FaixaEtaria.idenfificar(63).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(1500L).toString());
			reg.add(RESULTADO, Resultado.NEGADO.toString());
			//reg.add(LIMITE, Limite.REPROVADO.toString());
			dataset.add(reg);	
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.SOLTEIRO.toString());
			reg.add(DEPENDENTES, "2");
			reg.add(IDADE, FaixaEtaria.idenfificar(28).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(2500L).toString());
			reg.add(RESULTADO, Resultado.APROVADO.toString());
			//reg.add(LIMITE, Limite.LIMITE_100_500.toString());
			dataset.add(reg);		
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.SOLTEIRO.toString());
			reg.add(DEPENDENTES, "0");
			reg.add(IDADE, FaixaEtaria.idenfificar(16).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(500L).toString());
			reg.add(RESULTADO, Resultado.NEGADO.toString());
			//reg.add(LIMITE, Limite.RENDA_BAIXA.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.CASADO.toString());
			reg.add(DEPENDENTES, "5");
			reg.add(IDADE, FaixaEtaria.idenfificar(30).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(8000L).toString());
			reg.add(RESULTADO, Resultado.APROVADO.toString());
			//reg.add(LIMITE, Limite.LIMITE_1000_1500.toString());
			dataset.add(reg);	
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.VIUVO.toString());
			reg.add(DEPENDENTES, "0");
			reg.add(IDADE, FaixaEtaria.idenfificar(33).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(10000L).toString());
			reg.add(RESULTADO, Resultado.APROVADO.toString());
			//reg.add(LIMITE, Limite.SUPERIOR_2000.toString());
			dataset.add(reg);		
			
			// Definindo o atributo que queremos usar como classe
			dataset.setAtributoDeClasse(RESULTADO);
			
			dataSetResultado = dataset;
		}
		return dataSetResultado;
	}

	public void setDataSetResultado(DataSet dataSetResultado) {
		this.dataSetResultado = dataSetResultado;
	}

	public DataSet getDataSetLimite() {
		if(dataSetLimite == null) {
			Record reg;
			DataSet dataset = new DataSet();
		
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.SOLTEIRO.toString());
			reg.add(DEPENDENTES, "0");
			reg.add(IDADE, FaixaEtaria.idenfificar(28).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(2500L).toString());
			//reg.add(RESULTADO, Resultado.APROVADO.toString());
			reg.add(LIMITE, Limite.LIMITE_500_1000.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.SOLTEIRO.toString());
			reg.add(DEPENDENTES, "0");
			reg.add(IDADE, FaixaEtaria.idenfificar(17).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(1000L).toString());
			//reg.add(RESULTADO, Resultado.APROVADO.toString());
			reg.add(LIMITE, Limite.LIMITE_100_500.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.CASADO.toString());
			reg.add(DEPENDENTES, "3");
			reg.add(IDADE, FaixaEtaria.idenfificar(68).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(8000L).toString());
			//reg.add(RESULTADO, Resultado.APROVADO.toString());
			reg.add(LIMITE, Limite.LIMITE_1500_2000.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.CASADO.toString());
			reg.add(DEPENDENTES, "3");
			reg.add(IDADE, FaixaEtaria.idenfificar(61).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(5000L).toString());
			//reg.add(RESULTADO, Resultado.APROVADO.toString());
			reg.add(LIMITE, Limite.LIMITE_1000_1500.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.DIVORCIADO.toString());
			reg.add(DEPENDENTES, "2");
			reg.add(IDADE, FaixaEtaria.idenfificar(56).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(2000L).toString());
			//reg.add(RESULTADO, Resultado.NEGADO.toString());
			reg.add(LIMITE, Limite.REPROVADO.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.DIVORCIADO.toString());
			reg.add(DEPENDENTES, "1");
			reg.add(IDADE, FaixaEtaria.idenfificar(45).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(2000L).toString());
			//reg.add(RESULTADO, Resultado.NEGADO.toString());
			reg.add(LIMITE, Limite.REPROVADO.toString());
			dataset.add(reg);		
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.CASADO.toString());
			reg.add(DEPENDENTES, "2");
			reg.add(IDADE, FaixaEtaria.idenfificar(30).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(8000L).toString());
			//reg.add(RESULTADO, Resultado.APROVADO.toString());
			reg.add(LIMITE, Limite.SUPERIOR_2000.toString());
			dataset.add(reg);				
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.CASADO.toString());
			reg.add(DEPENDENTES, "1");
			reg.add(IDADE, FaixaEtaria.idenfificar(33).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(10000L).toString());
			//reg.add(RESULTADO, Resultado.APROVADO.toString());
			reg.add(LIMITE, Limite.SUPERIOR_2000.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.SOLTEIRO.toString());
			reg.add(DEPENDENTES, "1");
			reg.add(IDADE, FaixaEtaria.idenfificar(19).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(400L).toString());
			//reg.add(RESULTADO, Resultado.NEGADO.toString());
			reg.add(LIMITE, Limite.RENDA_BAIXA.toString());
			dataset.add(reg);		
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.VIUVO.toString());
			reg.add(DEPENDENTES, "3");
			reg.add(IDADE, FaixaEtaria.idenfificar(63).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(1500L).toString());
			//reg.add(RESULTADO, Resultado.NEGADO.toString());
			reg.add(LIMITE, Limite.REPROVADO.toString());
			dataset.add(reg);	
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.SOLTEIRO.toString());
			reg.add(DEPENDENTES, "2");
			reg.add(IDADE, FaixaEtaria.idenfificar(28).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(2500L).toString());
			//reg.add(RESULTADO, Resultado.APROVADO.toString());
			reg.add(LIMITE, Limite.LIMITE_100_500.toString());
			dataset.add(reg);		
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.SOLTEIRO.toString());
			reg.add(DEPENDENTES, "0");
			reg.add(IDADE, FaixaEtaria.idenfificar(16).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(500L).toString());
			//reg.add(RESULTADO, Resultado.NEGADO.toString());
			reg.add(LIMITE, Limite.RENDA_BAIXA.toString());
			dataset.add(reg);
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.CASADO.toString());
			reg.add(DEPENDENTES, "5");
			reg.add(IDADE, FaixaEtaria.idenfificar(30).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(8000L).toString());
			//reg.add(RESULTADO, Resultado.APROVADO.toString());
			reg.add(LIMITE, Limite.LIMITE_1000_1500.toString());
			dataset.add(reg);	
			
			reg = new Record();
			reg.add(ESTADO_CIVIL, EstadoCivil.VIUVO.toString());
			reg.add(DEPENDENTES, "0");
			reg.add(IDADE, FaixaEtaria.idenfificar(33).toString());
			reg.add(RENDA, FaixaSalarial.idenfificar(10000L).toString());
			//reg.add(RESULTADO, Resultado.APROVADO.toString());
			reg.add(LIMITE, Limite.SUPERIOR_2000.toString());
			dataset.add(reg);		
			
			// Definindo o atributo que queremos usar como classe
			dataset.setAtributoDeClasse(LIMITE);
			
			dataSetLimite = dataset;
		}
		return dataSetLimite;
	}

	public void setDataSetLimite(DataSet dataSetLimite) {
		this.dataSetLimite = dataSetLimite;
	}

}
