package br.com.calcard.api.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.ObjectError;

public class PropostaBackendException extends Exception {
	List<ObjectError> errors = new ArrayList<ObjectError>();
	
	public PropostaBackendException() {}
	
	public PropostaBackendException(List<ObjectError> errors) {
		this.errors = errors;
	}
	
	public void addError(ObjectError error) {
		this.errors.add(error);
	}

	public List<ObjectError> getErrors() {
		return this.errors;
	}
}
