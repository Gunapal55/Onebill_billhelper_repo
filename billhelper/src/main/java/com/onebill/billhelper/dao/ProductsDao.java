package com.onebill.billhelper.dao;

import java.util.List;

import com.onebill.billhelper.dto.ProductsDto;

public interface ProductsDao {

	public ProductsDto addProduct(ProductsDto product);
	
	public ProductsDto updateProduct(ProductsDto product);
	
	public ProductsDto removeProduct(ProductsDto product);
	
	public List<ProductsDto> getAllProduct();
	
	public ProductsDto getProductById(int productId);
	
}
