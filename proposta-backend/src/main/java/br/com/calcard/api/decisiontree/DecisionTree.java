package br.com.calcard.api.decisiontree;

/**
 * Representa a rvore de deciso capaz de classificar um novo registro com
 * base na estrutura de deciso construda a partir de uma base de dados de
 * treinamento.
 * 
 * @author Leandro Fernandes
 */
public class DecisionTree {
	
	private Node raiz = null;
	
	/**
	 * Constri a rvore de deciso para o conjunto de dados informado
	 * @param baseDados base de dados para treinamento
	 */
	public void construir(DataSet baseDados) {
		raiz = new Node(baseDados);
		raiz.construir();
	}
	
	/**
	 * Retorna a classificao dada para o registro informado, segundo
	 * a rvore de deciso construda anteriormente.
	 * @param registro
	 * @return
	 */
	public String getClassificacao(Record registro) {
		if (raiz == null)
			throw new RuntimeException("Impossvel classificar este registro, pois a rvore aidna no foi construda.");
		else {
			Node no = raiz;
			while (no != null && !no.isFolha()) {
				String valor = registro.getValor( no.getAtributo() );
				no = no.getProximoNode(valor);
			}
			return no == null ? "INCONCLUSIVO" : no.getValor();
		}
	}

	/**
	 * Representao na forma textual da estrutura hierrquica da rvore
	 */
	@Override
	public String toString() {
		return raiz.toString();
	}
}
