package com.capgemini.forestrymanagementsystemspring.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementsystemspring.config.ORMConfig;
import com.capgemini.forestrymanagementsystemspring.dao.ClientDAO;
import com.capgemini.forestrymanagementsystemspring.dto.UserAdmin;
import com.capgemini.forestrymanagementsystemspring.dto.UserClient;
import com.capgemini.forestrymanagementsystemspring.dto.UserContractor;
import com.capgemini.forestrymanagementsystemspring.dto.UserOrder;
import com.capgemini.forestrymanagementsystemspring.dto.UserProduct;
import com.capgemini.forestrymanagementsystemspring.springtest.SpringTest;

@SpringJUnitConfig(classes= {SpringTest.class,ORMConfig.class})
class ClientServiceImplTest {
	@Autowired
	private ClientDAO dao = null;
	private UserClient clientBean = null;
	private UserAdmin adminBean = null;
	private UserContractor contractorBean = null;
	private UserProduct productBean=null;

	@Test
	void testGetAllClient() {
		Set<UserClient> setClient=new  HashSet<UserClient>();
		setClient=dao.getAllClient();
		assertNotNull(setClient);
	}

	@Test
	void testOrderContracts() {
		try {
			contractorBean = new UserContractor();
			contractorBean.setContractorNo(201);
			contractorBean.setCustomerId(101);
			contractorBean.setDeliveryDate("12/12/2019");
			contractorBean.setDeliveryDay("sun");
			contractorBean.setHaulierId(110);
			contractorBean.setParcelId(101);
			contractorBean.setProductId(101);
			contractorBean.setQuantity(121);
			boolean check = dao.orderContracts(contractorBean);
			assertEquals(check,true);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	void testUpdateContract() {
		contractorBean=new UserContractor();
		contractorBean.setHaulierId(101);
		contractorBean.setContractorNo(122);
		contractorBean.setCustomerId(101);
		contractorBean.setDeliveryDate("29/1/2020");
		contractorBean.setDeliveryDay("mon");
		contractorBean.setProductId(101);
		contractorBean.setParcelId(101);
		contractorBean.setQuantity(212);
		boolean check=dao.updateContract(contractorBean,contractorBean.getHaulierId());
		assertEquals(check,true);
	}

	@Test
	void testDeleteContract() {
		contractorBean=new UserContractor();
		contractorBean.setHaulierId(110);
		boolean check=dao.deleteContract(contractorBean.getHaulierId());
		assertEquals(check,true);
	}

	@Test
	void testContractInformation() {
		Set<UserContractor> setContractor=new HashSet<UserContractor>();
		setContractor=dao.contractInformation();
		assertNotNull(setContractor);
	}

	@Test
	void testAddProduct() {
		productBean=new UserProduct();
		productBean.setProductDescription("Symbol_of_unity");
		productBean.setProductId(108);
		productBean.setProductName("Oak");
		boolean check=dao.addProduct(productBean);
		assertEquals(check,true);
	}

	@Test
	void testDeleteProduct() {
		productBean=new UserProduct();
		productBean.setProductId(108);
		boolean check=dao.deleteProduct(productBean.getProductId());
		assertEquals(check,true);
	}

	@Test
	void testUpdateProduct() {
		productBean=new UserProduct();
		productBean.setProductId(101);
		productBean.setProductName("Britainia");
		boolean check=dao.updateProduct(productBean.getProductName(), productBean.getProductId());
		assertEquals(check,true);
	}

	@Test
	void testShowOrder() {
		Set<UserOrder>  setOrder=new HashSet<UserOrder>();
		setOrder=dao.showOrder();
		assertNotNull(setOrder);
	}

	@Test
	void testClientLogin() {
		productBean=new UserProduct();
		productBean.setProductId(101);
		productBean.setProductName("Shisham");
		boolean check=dao.updateProduct(productBean.getProductName(),productBean.getProductId());
		assertEquals(check, true);
	}


}
