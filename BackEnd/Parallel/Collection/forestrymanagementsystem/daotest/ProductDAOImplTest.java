package com.capgimini.forestrymanagementsystem.daotest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgimini.forestrymanagementsystem.dao.ProductDAO;
import com.capgimini.forestrymanagementsystem.dao.ProductDAOImpl;
import com.capgimini.forestrymanagementsystem.dto.UserProduct;

class ProductDAOImplTest {
	private UserProduct productBean=null;
	private ProductDAO dao=new ProductDAOImpl();
	 Map<Integer,Set<UserProduct>> mapProduct=new HashMap<Integer, Set<UserProduct>>();

	@BeforeEach
	void addProduct() {
		productBean=new UserProduct();
		productBean.setProductDetail("Good_product");
		productBean.setProductId(101);
		productBean.setProductMRP(122);
		productBean.setProductName("Oak");
		boolean check=dao.addProduct(productBean);
		assertEquals(check,true);
	}
	@Test
	void testAddProduct() {
		productBean=new UserProduct();
		productBean.setProductDetail("Good_product");
		productBean.setProductId(101);
		productBean.setProductMRP(122);
		productBean.setProductName("Oak");
		boolean check=dao.addProduct(productBean);
		assertEquals(check,true);
	}

	@Test
	void testDeleteProduct() {
		productBean=new UserProduct();
		productBean.setProductId(101);
		Set<UserProduct> setProduct=new HashSet<UserProduct>();
		setProduct=dao.getProduct();
		mapProduct.put(productBean.getProductId(), setProduct);
		boolean check=dao.deleteProduct(101, mapProduct);
	}

	@Test
	void testGetProduct() {
		Set<UserProduct> setProduct=new HashSet<UserProduct>();
		setProduct=dao.getProduct();
		assertNotNull(setProduct);
	}

	@Test
	void testModifyProduct() {
		productBean=new UserProduct();
		productBean.setProductId(101);
		mapProduct.remove(productBean.getProductId());
		productBean.setProductDetail("Good_product");
		productBean.setProductId(101);
		productBean.setProductMRP(122);
		productBean.setProductName("Oak");
		boolean check=dao.addProduct(productBean);
		assertEquals(check,true);

	}

}
