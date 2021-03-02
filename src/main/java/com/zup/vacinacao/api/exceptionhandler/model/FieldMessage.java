package com.zup.vacinacao.api.exceptionhandler.model;

public class FieldMessage {

	private String name;
	private String message;
	
	public FieldMessage(String name, String message) {
		this.name = name;
		this.message = message;
	}

	public String getName() {
		return name;
	}
	
	public String getMessage() {
		return message;
	}

}
