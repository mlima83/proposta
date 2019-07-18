package br.com.calcard.api.decisiontree;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Representa um conjunto de dados, contm vrios casos de exemplo do problema. 
 * @author Leandro Fernandes
 */
public class DataSet {
	
	private List<Record> registros;
	private String atributoDeClasse;

	/**
	 * Cria um conjunto de dados para conter registros (exemplos) do problema. 
	 */
	public DataSet() {
		registros = new ArrayList<Record>();
		atributoDeClasse = "<no definido>";
	}
	
	/**
	 * Cria um conjunto de dados a partir de uma lista de registros j existentes.
	 * @param registros lista de registros que constituem o novo conjunto de dados 
	 * @param atributo nome do atributo de classe para o conjunto
	 */
	public DataSet(List<Record> registros, String atributo) {
		this.registros = registros;
		this.atributoDeClasse = atributo;
	}	
	
	/**
	 * Determina o atributo que ser utilizado pelo classificador como classe.
	 * @param atributo nome do atributo de classe
	 */
	public void setAtributoDeClasse(String atributo) {
		this.atributoDeClasse = atributo;
	}
	
	/**
	 * Retorna o nome do atributo classe
	 * @return atributo classe
	 */
	public String getAtributoDeClasse() {
		return this.atributoDeClasse;
	}
	
	/**
	 * Adiciona um novo exemplo a base de dados.
	 * @param reg coleo de pares (atributos-valor) que representam o exemplo
	 */
	public void add(Record reg) {
		registros.add(reg);
	}
	
	/**
	 * Retorna o n-simo registro do conjunto de dados
	 * @param index valor de ndice para o n-simo registro
	 * @return o registro desejado, caso ele exista; ou nulo, quando a base de
	 * dados  vazia ou a posio solicitada  inexistente.
	 */
	public Record getRegistroAt(int index) {
		if (registros.isEmpty())
			return null;
		else if (registros.size() <= index )
			return null;
		else
			return registros.get(index);
	}
	
	/**
	 * Retorna uma lista contendo todos os registros que compem a base de dados 
	 * @return lista de registros
	 */
	public List<Record> getRegistros() {
		return registros;
	}
	
	/**
	 * Retorna uma lista de registros que apresentam o valor especificado para
	 * o atributo informado
	 * @param atributo nome do atributo de referencia para a pesquisa
	 * @param valor valor desejado para o atributo selecionado
	 * @return conjunto de registros cujo atributo apresenta o valor desejado
	 */
	public DataSet getSubSet(String atributo, String valor) {
		if(valor == null)
			System.out.println("ddsds");
		if (registros.isEmpty())
			return null;
		else {
			List<Record> subConjunto = new ArrayList<Record>();
			for (Record registro : registros)
				if (valor.equals(registro.getValor(atributo)))
					subConjunto.add(registro);
			return new DataSet(subConjunto, atributoDeClasse);
		}
	}
	
	/**
	 * Mtodo auxiliar que recupera todos os valores possveis para um determinado
	 * atributo
	 * @param atributo nome do atributo desejado
	 * @return conjunto de valores possveis
	 */
	public Set<String> getValoresDoAtributo(String atributo) {
		if (registros.isEmpty())
			return null;
		else {
			Set<String> listaDeValores = new HashSet<String>();
			for (Record registro : registros)
				listaDeValores.add( registro.getValor(atributo) );			
			return listaDeValores;
		}
	}
	
	/**
	 * Calcula a entropia do conjunto de dados em relao ao atributo classe,
	 * segundo a frmula: Entropia(S) = -p/n * log2(p/n) -q/m * log_2(q/m) ...
	 * @return entropia do conjunto
	 */
	public double entropia() {
		return entropia(registros);
	}

	/**
	 * Calcula a entropia para um conjunto de registros em relao ao atributo
	 * classe, segundo a frmula: Entropia(S) = -p/n * log2(p/n) -q/m * log_2(q/m) ...
	 * @param registros lista de registros que compem a base de dados
	 * @return valor da entropia
	 */
	private double entropia(List<Record> registros) {
		if (atributoDeClasse.equals("<no definido>"))
			throw new RuntimeException("Atributo de classe no definido para o conjunto de dados");		
		else if (registros.isEmpty())
			return 0;
		else {
			double entropia = 0;
			String[] valores = getValoresDoAtributo(atributoDeClasse).toArray(new String[0]);
			for (String valor : valores) {
				DataSet subSet = getSubSet(atributoDeClasse, valor);
				double frac = ((double) subSet.size()) / registros.size();
				entropia += -frac * (Math.log(frac)/Math.log(2));
			}
			return entropia;
		}
	}
	
	/**
	 * Computa o ganho oferecido pelo atributo para a reduo na entropia, segundo
	 * a frmula: Ganho(A,S) = Entropia(S) -p/n * Entropia(SubSet_S(A)) ...
	 * @param atributo nome do atributo a ser considerado para o clculo do ganho
	 * @return ganho oferecido para a reduo da entropia
	 */
	public double ganho(String atributo) {
		if (registros.isEmpty())
			return 0;
		else {
			double ganho = entropia();
			String[] valores = getValoresDoAtributo(atributo).toArray(new String[0]);
			for (String valor : valores) {
				DataSet subSet = getSubSet(atributo, valor);
				double frac = ((double) subSet.size()) / registros.size();
				ganho += -frac * subSet.entropia();
			}
			return ganho;
		}
	}

	/**
	 * Retorna a quantidade de registros que compe a base de dados
	 * @return quantidade de registros
	 */
	public int size() {
		return registros.size();
	}
	
	/**
	 * Verifica se a base de dados est vazia
	 * @return verdadeiro ou falso
	 */
	public boolean isEmpty() {
		return registros.isEmpty();
	}

	/**
	 * Retorna a base de dados numa representao textual de forma tabular
	 */
	@Override
	public String toString() {
		String msg = "";
		List<String> atributos = registros.get(0).getAtributos();
		for (int i = 0; i < atributos.size(); i++)
			msg += "+---------------";
		msg += "+\n|";
		for(String atributo : atributos)
			if (atributo.equals(atributoDeClasse))
				msg += String.format("<<%-11s>>|", atributo);
			else
				msg += String.format("%-15s|", atributo);
		msg += "\n";
		for (int i = 0; i < atributos.size(); i++)
			msg += "+---------------";
		msg += "+\n";
		for (Record registro : registros) {
			msg += "|";
			for (String valor : registro.getValores())
				msg += String.format("%-15s|", valor);
			msg += "\n";
		}
		for (int i = 0; i < atributos.size(); i++)
			msg += "+---------------";
		msg += "+\n";
		return msg;
	}
	
}
