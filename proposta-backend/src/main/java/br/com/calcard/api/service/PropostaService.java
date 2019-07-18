package br.com.calcard.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.calcard.api.entity.Proposta;
import br.com.calcard.arq.service.AbstractService;

/**
 * Interface responsável por concentrar todos os métodos padrão de gerenciamento de porpostas que ficará disponível para o controller.
 * @author Marco
 *
 */
@Component
public interface PropostaService extends AbstractService<Proposta, Long>{

	/**
	 * Realiza a busca de um processo pelo numero
	 * @param page
	 * @param count
	 * @param number
	 * @return
	 */
	public Page<Proposta> findByClienteCpf(int page, int count, String cpf);
	
	/**
	 * Realiza a busca de um processo pelo numero
	 * @param page
	 * @param count
	 * @param number
	 * @return
	 */
	public Proposta findByClienteCpf(String number);
}
