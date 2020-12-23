package com.onebill.billhelper.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.onebill.billhelper.dto.ResponseDto;
import com.onebill.billhelper.exception.BillhelperException;

@RestControllerAdvice
@CrossOrigin(origins= "*")
public class ControllerAdvice {

	@ExceptionHandler
	public ResponseEntity<ResponseDto> handler(BillhelperException ex,  HttpServletRequest request, HttpServletResponse response) {
		ResponseDto dto = new ResponseDto();
			dto.setError(true);
		dto.setData(ex.getLocalizedMessage());
		return new ResponseEntity<ResponseDto>(dto,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}

