package com.onebill.billhelper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onebill.billhelper.dto.ProductsDto;

@Service
public interface ProductsService {

	public ProductsDto addProduct(ProductsDto product);

	public ProductsDto updateProduct(ProductsDto product);

	public ProductsDto removeProduct(int productId);

	public List<ProductsDto> getAllProduct();

	public ProductsDto getProductById(int productId);
	

}
