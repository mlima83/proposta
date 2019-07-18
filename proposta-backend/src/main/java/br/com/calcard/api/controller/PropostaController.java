package br.com.calcard.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.api.dto.PropostaRequest;
import br.com.calcard.api.dto.PropostaResponse;
import br.com.calcard.api.entity.Proposta;
import br.com.calcard.api.exception.PropostaBackendException;
import br.com.calcard.api.response.Response;
import br.com.calcard.api.service.PropostaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * Controller responsável pelo gerenciamento de propostaos
 * @author Marco
 *
 */
@RestController
@RequestMapping("/api/proposta")
@CrossOrigin(origins = "*")
@Api(value = "Proposta")
public class PropostaController {
	
	@Autowired
	private PropostaService propostaService;

	@PostMapping()
	@ApiOperation(value = "Criar proposta")
	public ResponseEntity<Response<PropostaResponse>> create(HttpServletRequest request, @RequestBody PropostaRequest proposta,
			BindingResult result) {
		Response<PropostaResponse> response = new Response<PropostaResponse>();
		try {
			Proposta propostaSalva = (Proposta) propostaService.createOrUpdate(proposta.getProposta());
			response.setData(new PropostaResponse(propostaSalva));
		} catch (DuplicateKeyException dE) {
			response.getErrors().add("Proposta already registered !");
			return ResponseEntity.badRequest().body(response);
		} catch (PropostaBackendException e) {
			e.getErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		} catch (Exception e) {
			e.printStackTrace();
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "{id}")
	@ApiOperation(value = "Buscar proposta pelo identificador")
	public ResponseEntity<Response<Proposta>> findById(@PathVariable("id") long id) {
		Response<Proposta> response = new Response<Proposta>();
		Proposta proposta = propostaService.findById(id);
		if (proposta == null) {
			response.getErrors().add("Registro não encontrado: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(proposta);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "find/{cpf}")
	@ApiOperation(value = "Buscar proposta pelo cpf do cliente")
	public ResponseEntity<Response<PropostaResponse>> findByCpf(@PathVariable("cpf") String cpf) {
		Response<PropostaResponse> response = new Response<PropostaResponse>();
		Proposta proposta = propostaService.findByClienteCpf(cpf);
		if (proposta == null) {
			response.getErrors().add("Registro não encontrado: " + cpf);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(new PropostaResponse(proposta));
		return ResponseEntity.ok(response);
	}
	
}
