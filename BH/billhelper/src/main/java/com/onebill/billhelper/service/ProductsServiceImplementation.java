package com.onebill.billhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.billhelper.dao.ProductsDao;
import com.onebill.billhelper.dto.ProductsDto;
import com.onebill.billhelper.exception.BillhelperException;

@Service
public class ProductsServiceImplementation implements ProductsService {

	@Autowired
	private ProductsDao productsdao;

	public void setProductDao(ProductsDao productsdao) {
		this.productsdao = productsdao;
	}

	@Override
	public ProductsDto addProduct(ProductsDto product) {
		System.out.println();
		ProductsDto addPro = productsdao.addProduct(product);
		if (addPro != null) {

			return addPro;
		} else {
			throw new BillhelperException("Record already exists");
		}
	}

	@Override
	public ProductsDto removeProduct(ProductsDto product) {

		ProductsDto remPro = productsdao.removeProduct(product);
		if (remPro != null) {

			return remPro;

		} else {
			throw new BillhelperException("No matching data found to remove");

		}
	}

	@Override
	public ProductsDto updateProduct(ProductsDto product) {
		ProductsDto updPro = productsdao.updateProduct(product);
		if (updPro != null) {

			return updPro;

		} else {
			throw new BillhelperException("No matching record found for update");

		}
	}

	@Override
	public List<ProductsDto> getAllProduct() {
		List<ProductsDto> proList = productsdao.getAllProduct();
		if (proList != null) {

			return proList;

		} else {
			throw new BillhelperException("No products found");

		}
	}

	@Override
	public ProductsDto getProductById(int productId) {
		ProductsDto getPro = productsdao.getProductById(productId);
		if (getPro != null) {

			return getPro;

		} else {
			throw new BillhelperException("No matching data found to fetch");

		}
	}

}
