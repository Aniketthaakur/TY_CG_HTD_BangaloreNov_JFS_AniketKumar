package com.cap.forestrymanagementsystem.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cap.forestrymanagementsystem.dao.ClientDAO;
import com.cap.forestrymanagementsystem.dao.ClientDAOImpl;
import com.cap.forestrymanagementsystem.dto.UserAdmin;
import com.cap.forestrymanagementsystem.dto.UserClient;
import com.cap.forestrymanagementsystem.dto.UserContractor;
import com.cap.forestrymanagementsystem.dto.UserOrder;
import com.cap.forestrymanagementsystem.dto.UserProduct;

class ClientServiceImplTest {

	private UserClient clientBean = null;
	private UserAdmin adminBean = null;
	private ClientDAO dao = null;
	private UserContractor contractorBean = null;
	private UserProduct productBean=null;

	@BeforeEach
	void load() {
		dao = new ClientDAOImpl();
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
	void testUpdateProduct() {
		productBean=new UserProduct();
		productBean.setProductId(101);
		productBean.setProductName("Britainia");
		boolean check=dao.updateProduct(productBean.getProductId(), productBean.getProductName());
		assertEquals(check,true);
	}

	@Test
	void testShowOrder() {
		Set<UserOrder>  setOrder=new HashSet<UserOrder>();
		setOrder=dao.showOrder();
		assertNotNull(setOrder);
	}

	@Test
	void testGetAllClient() {
		Set<UserClient> setClient=new  HashSet<UserClient>();
		setClient=dao.getAllClient();
		assertNotNull(setClient);
	}

	@Test
	void testUpdateContract() {
		contractorBean=new UserContractor();
		contractorBean.setHaulierId(101);
		contractorBean.setContractorNo(122);
		boolean check=dao.updateContract(contractorBean.getContractorNo(),contractorBean.getHaulierId());
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
	void testClientLogin() {
		productBean=new UserProduct();
		productBean.setProductId(101);
		productBean.setProductName("Shisham");
		boolean check=dao.updateProduct(productBean.getProductId(),productBean.getProductName());
		assertEquals(check, true);
	}

	@Test
	void testContractInformation() {
		Set<UserContractor> setContractor=new HashSet<UserContractor>();
		setContractor=dao.contractInformation();
		assertNotNull(setContractor);
	}

	@Test
	void testSearchProduct() {
		productBean=new UserProduct();
		productBean.setProductId(101);
		boolean check=dao.searchProduct(productBean.getProductId());
		assertEquals(check,true);
	}

	@Test
	void testSearchClient() {
		clientBean=new  UserClient();
		clientBean.setCustomerId(102);
		boolean check=dao.searchClient(clientBean.getCustomerId());
		assertEquals(check, true);
	}
}
