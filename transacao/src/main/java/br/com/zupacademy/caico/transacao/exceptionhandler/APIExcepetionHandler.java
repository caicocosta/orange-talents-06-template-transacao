package br.com.zupacademy.caico.transacao.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.zupacademy.caico.transacao.exception.Exceptions;

@ControllerAdvice
public class APIExcepetionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exceptions.class)
	public ResponseEntity<Object> handleExceptions(Exceptions ex, WebRequest request){
		
		var status = HttpStatus.BAD_REQUEST;
		var errosDTO = new ErrosDTO();
		
		errosDTO.setStatus(status.value());
		errosDTO.setDataHora(OffsetDateTime.now());
		errosDTO.setTitulo(ex.getMessage());
				
		return handleExceptionInternal(ex, errosDTO, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var campos = new ArrayList<ErrosDTO.Campo>();
		
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) error).getField();
			String mensagem = error.getDefaultMessage();
			
			campos.add(new ErrosDTO.Campo(nome, mensagem));
		}
		
		var errosDTO = new ErrosDTO();
		errosDTO.setStatus(status.value());
		errosDTO.setTitulo("Um ou mais campos estão inválidos. "
				   + "Faça o preenchiento correto e tente novamente");
		errosDTO.setDataHora(OffsetDateTime.now());
		errosDTO.setCampos(campos);

		return super.handleExceptionInternal(ex, errosDTO, headers, status, request);
	}
	
	@ExceptionHandler(ApiErroException.class)
	public ResponseEntity<ErrosDTO> handleApiErroException(ApiErroException apiErroException) {
	    
		var status = apiErroException.getHttpStatus();
		var errosDTO = new ErrosDTO();
		
		errosDTO.setStatus(status.value());
		errosDTO.setDataHora(OffsetDateTime.now());
		errosDTO.setTitulo(apiErroException.getReason());

	    return ResponseEntity.status(apiErroException.getHttpStatus()).body(errosDTO);
	}
}
