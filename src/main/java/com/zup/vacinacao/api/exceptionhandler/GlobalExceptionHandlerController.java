package com.zup.vacinacao.api.exceptionhandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zup.vacinacao.api.exceptionhandler.model.StandardErrorResponse;
import com.zup.vacinacao.domain.exception.BusinessException;

@ControllerAdvice
public class GlobalExceptionHandlerController {

	private static final String MENSAGEM_ERRO_VALIDACAO_CAMPOS = "Erro ao validar campos";
	private static final String MENSAGEM_ERRO_CADASTRO = "Erro ao realizar cadastro"; 
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<StandardErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String path = request.getRequestURI();

		StandardErrorResponse errorResponse = 
				new StandardErrorResponse(status.value(), MENSAGEM_ERRO_VALIDACAO_CAMPOS, ex.getMessage(), path);

		ex.getBindingResult().getFieldErrors().forEach(f -> errorResponse.addError(f.getField(), f.getDefaultMessage()));

		return ResponseEntity.status(status).body(errorResponse);
	}
	
	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<StandardErrorResponse> handleBusinessException(BusinessException ex,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String path = request.getRequestURI();

		StandardErrorResponse errorResponse = 
				new StandardErrorResponse(status.value(), MENSAGEM_ERRO_CADASTRO, ex.getMessage(), path);

		return ResponseEntity.status(status).body(errorResponse);
	}
	
}
