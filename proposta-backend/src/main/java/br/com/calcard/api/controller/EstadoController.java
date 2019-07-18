package br.com.calcard.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.api.dto.EstadoResponse;
import br.com.calcard.api.entity.Estado;
import br.com.calcard.api.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * Controller responsável pelo gerenciamento de estado
 * @author Marco
 *
 */
@RestController
@RequestMapping("/api/estado")
@CrossOrigin(origins = "*")
@Api(value = "Estado")
public class EstadoController {

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Buscar o estado pelo identificador")
	public ResponseEntity<Response<EstadoResponse>> findById(@PathVariable("id") String id) {
		Response<EstadoResponse> response = new Response<EstadoResponse>();
		response.setData(new EstadoResponse(Estado.valueOf(id)));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "")
	@ApiOperation(value = "Buscar todos os estados")
    public  ResponseEntity<Response<List<EstadoResponse>>> findAll() {
		Response<List<EstadoResponse>> response = new Response<List<EstadoResponse>>();
		List<EstadoResponse> list = new ArrayList<EstadoResponse>();
		Arrays.asList(Estado.values()).forEach(estado -> list.add(new EstadoResponse(estado)));
		response.setData(list);
		return ResponseEntity.ok(response);
    }
	
}
