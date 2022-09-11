package com.harsha.coupondbservice.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.harsha.coupondbservice.bean.ErrorResponse;

@RestControllerAdvice
public class GloabalExceptionHandler {
	@Autowired
	ErrorResponse errorResponse;

	@ExceptionHandler(MissingRequestHeaderException.class)
	ResponseEntity<ErrorResponse> missingRequestHeader(MissingRequestHeaderException e) {

		errorResponse.setCause(e.getMessage());
		errorResponse.setValue(e.getHeaderName());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
