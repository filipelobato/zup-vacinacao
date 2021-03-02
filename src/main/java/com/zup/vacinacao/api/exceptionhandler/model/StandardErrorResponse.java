package com.zup.vacinacao.api.exceptionhandler.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StandardErrorResponse {

	private Instant timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	
	@JsonProperty("errors")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<FieldMessage> errorsValidation = new ArrayList<>();
	
	public StandardErrorResponse(int status, String error, String message, String path) {
		this.timestamp = Instant.now();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	public Instant getTimestamp() {
		return timestamp;
	}

	public int getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public List<FieldMessage> getErrorsValidation() {
		return errorsValidation;
	}

	public void addError(String name, String message) {
		this.errorsValidation.add(new FieldMessage(name, message));
	}
	
}
