package com.caps.dao;

import java.util.HashSet;
import java.util.Set;

import com.caps.userbean.dto.UserProduct;

public class ProductDAOImpl implements ProductDAO {
	Set<UserProduct> s;
	@Override
	public boolean addProduct(UserProduct bean) {
		s=new HashSet<UserProduct>();
		s.add(bean);
		return true;
	}

	@Override
	public boolean deleteProduct(int productId, UserProduct bean) {

		if(bean.getProductId()!=productId)
		{
			return true;
		}
		return false;
	}

	@Override
	public Set<UserProduct> getProduct() {
		return s;
	}

	@Override
	public boolean modifyProduct(int productId, UserProduct bean) 
	{
		if(bean.getProductId()!=productId)
		{
			return true;
		}
		return false;
	}

}
