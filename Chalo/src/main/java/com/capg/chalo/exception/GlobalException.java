//package com.capg.chalo.exception;
//
//import java.time.LocalDateTime;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//@RestControllerAdvice
//public class GlobalException extends ResponseEntityExceptionHandler {
//	
//	@ExceptionHandler
//	public ResponseEntity<ErrorInfo> customException(CustomException exception){
//		ErrorInfo errorInfo = new ErrorInfo();
//		errorInfo.setErrorMessage(exception.getMsg());
//		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
//		errorInfo.setLocalDateTime(LocalDateTime.now());
//	}
//}
