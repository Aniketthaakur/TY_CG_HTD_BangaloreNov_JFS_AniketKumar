package com.capgimini.forestrymanagementsystem.service;

import java.util.Map;
import java.util.Set;

import com.capgimini.forestrymanagementsystem.dto.UserProduct;

public interface ProductService {

	public boolean addProduct(UserProduct bean);
	 public boolean deleteProduct(int productId, Map<Integer,Set<UserProduct>> map);
	 public Set<UserProduct> getProduct();
	 public boolean modifyProduct(int productId,UserProduct bean);
}
