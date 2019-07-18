package br.com.calcard.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.calcard.api.entity.Cliente;


/**
 * Classe responsável pelo acesso aos dados da proposta 
 * @author Marco
 *
 */
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>  {
	
	Page<Cliente> findByCpf(String cpf,Pageable pages);
	
	Cliente findByCpf(String cpf);
}
