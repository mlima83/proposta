package br.com.calcard.api.service;

import org.springframework.stereotype.Component;

import br.com.calcard.api.entity.Cliente;
import br.com.calcard.arq.service.AbstractService;

/**
 * Interface responsável por concentrar todos os métodos padrão de gerenciamento de perecer de processos que ficará disponível para o controller.
 * @author Marco
 *
 */
@Component
public interface ClienteService extends AbstractService<Cliente, Long> {
	
	public Cliente findByCpf(String cpf);
	
}
