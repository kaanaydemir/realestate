package com.people.realestate.advice;

import com.people.realestate.dtos.base.ResponseHeader;
import com.people.realestate.enums.ResponseType;
import com.people.realestate.exception.LocationNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult()
                .getFieldErrors();
        List<ObjectError> globalErrors = ex.getBindingResult()
                .getGlobalErrors();
        List<String> errors = new ArrayList<>(fieldErrors.size() + globalErrors.size());
        String error;
        for (FieldError fieldError : fieldErrors) {
            error = fieldError.getField() + " : " + fieldError.getDefaultMessage();
            errors.add(error);
        }
        for (ObjectError objectError : globalErrors) {
            error = objectError.getObjectName() + " : " + objectError.getDefaultMessage();
            errors.add(error);
        }
        ErrorMessage errorMessage = new ErrorMessage(errors);
        return new ResponseEntity(errorMessage, headers, status);
    }

    @ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleLocationNotFoundException(LocationNotFoundException ex) {
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setResponseType(ResponseType.ERROR);
        responseHeader.setResponseMessage(ex.getMessage());
        responseHeader.setResponseCode(HttpStatus.NOT_FOUND.value());
        responseHeader.setResponseDescription(ex.getMessage());


        return new ResponseEntity(responseHeader, HttpStatus.NOT_FOUND);
    }
}
