package com.onebill.billhelper.test;

import java.util.ArrayList;
import java.util.List;

import com.onebill.billhelper.dao.ProductsDao;
import com.onebill.billhelper.dto.ProductsDto;

import lombok.Data;

@Data
public class ProductDaoTestStub implements ProductsDao {

	
	
	@Override
	public ProductsDto addProduct(ProductsDto product) {
	ProductsDto dto = new ProductsDto();
	dto.setProductId(1);
	dto.setProductName("Apple");
	dto.setProductType("Technology");
		return dto;
	}

	@Override
	public ProductsDto updateProduct(ProductsDto product) {
		ProductsDto dto = new ProductsDto();
		dto.setProductId(product.getProductId());
		dto.setProductName("LG");
		dto.setProductType("Technology");
			return dto;
	}
	
//	@Override
//	public ProductsDto removeProduct(int productId) {
//		return this.productId;
//	}

	@Override
	public List<ProductsDto> getAllProduct() {
	ProductsDto dto1 = new ProductsDto();
	dto1.setProductId(101);
	dto1.setProductName("Apple");
	dto1.setProductType("Technology");
	ProductsDto dto2 = new ProductsDto();
	dto2.setProductId(104);
	dto2.setProductName("Samsung");
	dto2.setProductType("Technology");
	List<ProductsDto> list = new ArrayList<>();
	list.add(dto1);
	list.add(dto2);
	return list;
	}

	@Override
	public ProductsDto getProductById(int  productId) {
		ProductsDto dto3 = new ProductsDto();
		dto3.setProductId(101);
		dto3.setProductName("Apple");
		dto3.setProductType("Technology");
		return dto3;
	}

	@Override
	public ProductsDto removeProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
