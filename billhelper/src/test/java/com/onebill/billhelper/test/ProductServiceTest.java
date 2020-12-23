package com.onebill.billhelper.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.onebill.billhelper.dto.ProductsDto;
import com.onebill.billhelper.service.ProductsServiceImplementation;

class ProductServiceTest {

	// @InjectMocks
	// ProdcutsController productController;
	//
	// @Mock
	// ProductsServiceImplementation productService;

	private ProductsServiceImplementation productService;
	private ProductsDto productDto;

	@BeforeEach
	void setUp() {

		// MockitoAnnotations.initMocks(this);

		productService = new ProductsServiceImplementation();
		productService.setProductDao(new ProductDaoTestStub());
		productDto = new ProductsDto();
		productDto.setProductId(101);
		productDto.setProductName("Apple");
		productDto.setProductType("Technology");

	}

	@Test
	void testAddProducts() {
		ProductsDto product = productService.addProduct(productDto);
		assertEquals(product.getProductName(), productDto.getProductName());
	}

//	@Test
//	void testRemoveProducts() {
//		ProductsDto product = productService.removeProduct(productDto);
//		assertEquals(productDto.getProductName(), product.getProductName());
//	}

	@Test
	void testUpdateProducts() {
		ProductsDto product = productService.updateProduct(productDto);
		assertNotEquals(productDto, product);
	}

	@Test
	void testGetAllProducts() {
		List<ProductsDto> productList = productService.getAllProduct();
		assertNotNull(productList);
	}

	@Test
	void testGetProductById() {
		ProductsDto product = productService.getProductById(1);
		assertEquals(101, product.getProductId());
	}

}
