package br.com.calcard.api.decisiontree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Processa arquivos para construir bases de dados com as suas informaes
 * @author Leandro Fernandes
 */
public class ParseFile {
	
	private static final String DEFAULT_FILE = "dataset.txt";
	
	private String arquivo = DEFAULT_FILE;
	private BufferedReader fileReader = null;

	/**
	 * Define o arquivo que ser utilizado para a extrao dos dados que
	 * constituiro a base de treinamento para a problema. 
	 * @param nomeDoArquivo caminho que identifica o arquivo
	 */
	public void setArquivo(String nomeDoArquivo) {
		arquivo = nomeDoArquivo;
	}
	
	/**
	 * Mtodo auxiliar que realiza a leitura das informaes da primeira linha 
	 * do arquivo a fim de extrair o nome dos atributos
	 * @return lista contendo os nomes dos atributos
	 * @throws IOException
	 */
	private List<String> getAtributos() throws IOException {
		List<String> atributos = new ArrayList<String>();
		
		String primeiraLinha = fileReader.readLine();
		StringTokenizer st = new StringTokenizer(primeiraLinha, ",");
		while (st.hasMoreTokens()) {
			atributos.add( st.nextToken() );
		}
		return atributos.isEmpty() ? null : atributos;
	}
	
	/**
	 * Realiza a leitura do contedo do arquivo, estruturando os dados na forma
	 * de registros e construindo assim a base de dados para treinamento. 
	 * @return base de dados com as informaes oriundas do arquivo
	 * @throws IOException representa eventuais falhas no processo 
	 */
	public DataSet getRegistros() throws IOException {		
		
		File arq = new File(arquivo);
		if (fileReader == null) {
			FileInputStream fis = new FileInputStream(arq);
			fileReader = new BufferedReader(new InputStreamReader(fis));
		}
		
		DataSet dataset = new DataSet();
		// efetua a leitura dos atributos
		List<String> atributos = getAtributos();
		// efetua a leitura dos registros
		String linha;
		while ((linha = fileReader.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(linha, ",");
			if (st.countTokens() != atributos.size())
				throw new IOException("Comprimento do registro incorreto, valores faltanto.");
			else {
				Record reg = new Record();
				for (String atributo : atributos)
					reg.add(atributo, st.nextToken());
				dataset.add(reg);
			}
		}
		
		return dataset;
	}
}
