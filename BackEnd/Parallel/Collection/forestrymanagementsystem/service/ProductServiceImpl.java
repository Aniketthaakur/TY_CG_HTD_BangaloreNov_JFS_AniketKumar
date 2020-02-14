package com.capgimini.forestrymanagementsystem.service;

import java.util.Map;
import java.util.Set;

import com.capgimini.forestrymanagementsystem.dao.ProductDAO;
import com.capgimini.forestrymanagementsystem.dao.ProductDAOImpl;
import com.capgimini.forestrymanagementsystem.dto.UserProduct;

public class ProductServiceImpl implements ProductService {
	ProductDAO dao=new ProductDAOImpl();
	@Override
	public boolean addProduct(UserProduct bean) {
		return dao.addProduct(bean);
	}

	@Override
	public boolean deleteProduct(int productId, Map<Integer,Set<UserProduct>> map) {
		return dao.deleteProduct(productId, map);
	}

	@Override
	public Set<UserProduct> getProduct() {
		return dao.getProduct();
	}

	@Override
	public boolean modifyProduct(int productId, UserProduct bean) {
		// TODO Auto-generated method stub
		return false;
	}

}
