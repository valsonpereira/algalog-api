package com.algaworks.algalog.exceptionhandler;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Problema.Campo> campos = new ArrayList<>();

        for(ObjectError error : ex.getBindingResult().getAllErrors()){
            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            campos.add(new Problema.Campo(nome, mensagem));

        }
        Problema problema = new Problema();
        problema.setDataHora(LocalDateTime.now());
        problema.setStatus(status.value());
        problema.setTitulo("Um ou mais campos estao invalidos. Faca o preenchimento correto e tente novamente");
        problema.setCampos(campos);

        return handleExceptionInternal(ex, problema, headers, status, request);
    }
}
