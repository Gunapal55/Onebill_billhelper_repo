package com.onebill.billhelper.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onebill.billhelper.dto.ResponseDto;

@RestControllerAdvice
@CrossOrigin(origins= "*")
public class ControllerAdvice {

	
	@ExceptionHandler
	public ResponseDto handler(Exception e) {
		ResponseDto dto = new ResponseDto();
		dto.setError(true);
		dto.setData(e.getMessage());
		return dto;
	}
}
	

