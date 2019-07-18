package br.com.calcard.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import br.com.calcard.api.entity.Cliente;
import br.com.calcard.api.exception.PropostaBackendException;
import br.com.calcard.api.repository.ClienteRepository;
import br.com.calcard.api.service.ClienteService;
import br.com.calcard.arq.service.AbstractServiceImpl;;
/**
 * Implementação dos métodos responsáveis por gerenciar os feedbacks dos processos do sistema
 * @author Marco
 *
 */
@Service
public class ClienteServiceImpl extends AbstractServiceImpl<Cliente, Long> implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository; 
	
	@Override
	public void validateCreate(Cliente obj) throws PropostaBackendException {
		List<ObjectError> errors = new ArrayList<ObjectError>();
		if(obj == null) {
			errors.add(new ObjectError("cliente", "O Cliente deve ser informado"));
		}else {
			if(obj.getNome() == null || "".equals(obj.getNome())) {
				errors.add(new ObjectError("nome", "Nome é obrigatório"));
			}
			if(obj.getCpf() == null || "".equals(obj.getCpf())) {
				errors.add(new ObjectError("nome", "CPF é obrigatório"));
			}
			if(obj.getDependentes() == null || obj.getDependentes() < 0) {
				errors.add(new ObjectError("dependentes", "Dependentes é obrigatório"));
			}
			if(obj.getEstado() == null) {
				errors.add(new ObjectError("estado", "Estado é obrigatório"));
			}
			if(obj.getEstadoCivil() == null) {
				errors.add(new ObjectError("estadoCivil", "Estado civil é obrigatório"));
			}
			if(obj.getSexo() == null) {
				errors.add(new ObjectError("sexo", "Sexo é obrigatório"));
			}
			if(obj.getIdade() == null || obj.getIdade() <= 0) {
				errors.add(new ObjectError("idade", "Idade é obrigatório"));
			}
		}
		if(errors.size() > 0)
			throw new PropostaBackendException(errors);
	}
	
	public Cliente findByCpf(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}
	@Override
	public PagingAndSortingRepository<Cliente, Long> getRepository() {
		return this.clienteRepository;
	}
}
