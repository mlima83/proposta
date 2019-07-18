package br.com.calcard.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.calcard.api.entity.Proposta;


/**
 * Classe responsável pelo acesso aos dados da proposta 
 * @author Marco
 *
 */
public interface PropostaRepository extends PagingAndSortingRepository<Proposta, Long>  {
	
	Page<Proposta> findByClienteCpf(@Param("cpf")String cpf,Pageable pages);
	
	Proposta findByClienteCpf(String cpf);
}
