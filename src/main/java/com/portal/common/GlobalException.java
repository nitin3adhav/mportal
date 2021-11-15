package com.portal.common;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.portal.bean.ResponseMessageBean;

@RestControllerAdvice
public class GlobalException {

	
	
	
	
	//To validate error message 
	@ExceptionHandler
	public ResponseMessageBean validationErrorHandling(MethodArgumentNotValidException notValidException) {
		
		return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE, notValidException.getBindingResult().getFieldError().getDefaultMessage());
	}
}
