package br.com.calcard.arq.service;

import java.io.Serializable;

import org.springframework.data.domain.Page;

import br.com.calcard.api.exception.PropostaBackendException;

/**
 * Interface abstrata para services do projeto
 * @author Marco
 *
 * @param <T>
 * @param <ID>
 */
public interface AbstractService<T, ID extends Serializable> {
	
	/**Cria ou atualiza uma entidade
	 * @throws PropostaBackendException */
	public T createOrUpdate(T obj) throws PropostaBackendException;

	/**Busca pelo id*/
	public T findById(ID id);

	/**Remove uma entidade*/
	public void delete(ID id);

	/**Recupera todas com paginação*/
	public Page<T> findAll(int page, int count);
	
	/**Validação chamada antes de método de createOrUpdate, se necessário, deve ser sobrescrito pelo service*/
	public void validateCreate(T obj) throws PropostaBackendException;
}
