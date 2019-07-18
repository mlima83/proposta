package br.com.calcard.arq.service;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.calcard.api.exception.PropostaBackendException;

public abstract class AbstractServiceImpl<T, ID extends Serializable> implements AbstractService<T, ID>{
	
	@Override
	public T createOrUpdate(T obj) throws PropostaBackendException {
		validateCreate(obj);
		return getRepository().save(obj);
	}

	public T findById(ID id) {
		return (T) getRepository().findById(id);
	}

	public void delete(ID id) {
		getRepository().deleteById(id);
	}

	public Page<T> findAll(int page, int count) {
		Pageable pages = new PageRequest(page, count);
		return getRepository().findAll(pages);
	}
	
	public void validateCreate(T obj) throws PropostaBackendException{}
	
	public abstract PagingAndSortingRepository<T, ID> getRepository();

}
