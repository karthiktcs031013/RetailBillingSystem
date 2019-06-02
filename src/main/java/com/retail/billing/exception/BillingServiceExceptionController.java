package com.retail.billing.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class BillingServiceExceptionController extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillingServiceException.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        List<ObjectError> fieldErrors = ex.getBindingResult().getAllErrors();
        List<String> errorMsg = fieldErrors.stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
        return new ResponseEntity<>(errorMsg, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = BillingServiceException.class)
    public ResponseEntity<String> billingServiceException(BillingServiceException billingException) {
        return new ResponseEntity<>(billingException.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
