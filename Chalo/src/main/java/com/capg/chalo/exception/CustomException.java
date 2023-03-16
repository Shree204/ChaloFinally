package com.capg.chalo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String msg;
}
