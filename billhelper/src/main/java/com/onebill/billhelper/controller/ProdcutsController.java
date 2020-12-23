package com.onebill.billhelper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.billhelper.dto.ProductsDto;
import com.onebill.billhelper.dto.ResponseDto;
import com.onebill.billhelper.service.ProductsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProdcutsController {

	@Autowired
	private ProductsService service;

	@ResponseBody
	@PostMapping
	public ResponseDto getProduct(@RequestBody ProductsDto product) {
		ResponseDto response = new ResponseDto();
		response.setData(service.addProduct(product));
		return response;
	}

	@PutMapping
	public ResponseDto updateProduct(@RequestBody ProductsDto product) {
		ResponseDto response = new ResponseDto();
		response.setData(service.updateProduct(product));
		return response;
	}

	@DeleteMapping
	public ResponseDto removeProduct(@RequestBody ProductsDto product) {
		ResponseDto response = new ResponseDto();
		response.setData(service.removeProduct(product));
		return response;

	}

	@GetMapping("/products")
	public ResponseDto getAllProducts() {
		ResponseDto response = new ResponseDto();
		response.setData(service.getAllProduct());
		return response;

	}

	@GetMapping("/{productId}")
	public ResponseDto getProductById(@PathVariable int productId) {
		ResponseDto response = new ResponseDto();
		response.setData(service.getProductById(productId));
		return response;

	}

}
