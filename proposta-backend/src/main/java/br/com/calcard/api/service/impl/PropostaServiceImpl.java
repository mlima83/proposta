package br.com.calcard.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import br.com.calcard.api.decisiontree.DecisionTree;
import br.com.calcard.api.decisiontree.Record;
import br.com.calcard.api.decisiontree.config.DataSetFactory;
import br.com.calcard.api.decisiontree.config.FaixaEtaria;
import br.com.calcard.api.decisiontree.config.FaixaSalarial;
import br.com.calcard.api.entity.Limite;
import br.com.calcard.api.entity.Proposta;
import br.com.calcard.api.entity.Resultado;
import br.com.calcard.api.exception.PropostaBackendException;
import br.com.calcard.api.repository.PropostaRepository;
import br.com.calcard.api.service.ClienteService;
import br.com.calcard.api.service.PropostaService;
import br.com.calcard.arq.service.AbstractServiceImpl;
/**
 * Implementação dos métodos responsáveis por gerenciar os processos do sistema
 * @author Marco
 *
 */
@Service
public class PropostaServiceImpl extends AbstractServiceImpl<Proposta, Long> implements PropostaService {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private PropostaRepository propostaRepository; 
	
	public Page<Proposta> findByClienteCpf(int page, int count, String cpf){
		Pageable pages = new PageRequest(page, count);
		return this.propostaRepository.findByClienteCpf(cpf, pages);
	}
	
	@Override
	public Proposta findByClienteCpf(String cpf) {
		return this.propostaRepository.findByClienteCpf(cpf);
	}

	@Override
	public PagingAndSortingRepository<Proposta, Long> getRepository() {
		return this.propostaRepository;
	}
	
	@Override
	public Proposta createOrUpdate(Proposta obj) throws PropostaBackendException {
		clienteService.validateCreate(obj.getCliente());
		validateCreate(obj);
		gerarResultado(obj);
		Proposta propostaDb =  propostaRepository.findByClienteCpf(obj.getCliente().getCpf());
		if(propostaDb != null) {
			obj.getCliente().setId(propostaDb.getCliente().getId());
			obj.setId(propostaDb.getId());
		}
		obj.setCliente(clienteService.createOrUpdate(obj.getCliente()));
		return super.createOrUpdate(obj);
	}
	
	private void gerarResultado(Proposta obj) {
		DecisionTree arvDecisao = new DecisionTree();
		
		// Vamos criar um novo registro para ver qual seria a sua classificao
		Record registro = new Record();
		registro.add(DataSetFactory.ESTADO_CIVIL, obj.getCliente().getEstadoCivil().toString());
		registro.add(DataSetFactory.DEPENDENTES, obj.getCliente().getDependentes().toString());
		registro.add(DataSetFactory.IDADE, FaixaEtaria.idenfificar(obj.getCliente().getIdade()).toString());
		registro.add(DataSetFactory.RENDA, FaixaSalarial.idenfificar(obj.getRenda()).toString());
		
		arvDecisao.construir(DataSetFactory.getInstance().getDataSetResultado());
		
		Resultado resultado = Resultado.valueOf(arvDecisao.getClassificacao(registro));
		
		arvDecisao.construir(DataSetFactory.getInstance().getDataSetLimite());
		
		Limite limite = Limite.valueOf(arvDecisao.getClassificacao(registro));
		
		obj.setResultadoAnalise(resultado);
		obj.setLimiteAprovado(limite);
	}

	@Override
	public void validateCreate(Proposta obj) throws PropostaBackendException {
		List<ObjectError> errors = new ArrayList<ObjectError>();
		if(obj.getRenda() == null || obj.getRenda() == 0) {
			errors.add(new ObjectError("renda", "Renda é obrigatório"));
		}
		if(errors.size() > 0)
			throw new PropostaBackendException(errors);
	}
}
