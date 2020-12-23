package com.onebill.billhelper.dao;

import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.onebill.billhelper.dto.ProductsDto;
import com.onebill.billhelper.entity.Products;

@Repository
public class ProductsDaoImplementation implements ProductsDao {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public ProductsDto addProduct(ProductsDto product) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		Products pro = new Products();
		BeanUtils.copyProperties(product, pro);
		manager.persist(pro);
		ProductsDto dto = new ProductsDto();
		BeanUtils.copyProperties(pro, dto);
		manager.getTransaction().commit();
		manager.close();
		return dto;
	}

	@Override
	public ProductsDto updateProduct(ProductsDto updateProduct) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Products updatedProduct = manager.find(Products.class, updateProduct.getProductId());
		BeanUtils.copyProperties(updateProduct, updatedProduct);
		ProductsDto dto = new ProductsDto();
		BeanUtils.copyProperties(updatedProduct, dto);
		manager.getTransaction().commit();
		manager.close();
		return dto;
	}

	@Override
	public ProductsDto removeProduct(int productId) {
		System.out.println(productId);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Products deletedProduct = manager.find(Products.class, productId);
		ProductsDto dto = new ProductsDto();
		BeanUtils.copyProperties(deletedProduct, dto);
		if (deletedProduct != null) {
			manager.remove(deletedProduct);
			manager.getTransaction().commit();
			manager.close();
			return dto;
		} else {
			manager.close();
			factory.close();
			return null;
		}
	}

	@Override
	public List<ProductsDto> getAllProduct() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Products> query = manager.createQuery("FROM Products", Products.class);
		List<Products> products = query.getResultList();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<ProductsDto>>() {
		}.getType();
		List<ProductsDto> dto = mapper.map(products, listType);
		return dto;
	}

	@Override
	public ProductsDto getProductById(int productId) {
		EntityManager manager = factory.createEntityManager();
		Products pro = manager.find(Products.class, productId);
		ProductsDto dto = new ProductsDto();
		BeanUtils.copyProperties(pro, dto);
		manager.close();
		return dto;

	}

	
}