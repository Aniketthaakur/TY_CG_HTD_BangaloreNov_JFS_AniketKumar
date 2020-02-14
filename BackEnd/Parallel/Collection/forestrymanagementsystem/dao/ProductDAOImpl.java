package com.capgimini.forestrymanagementsystem.dao;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import com.capgimini.forestrymanagementsystem.dto.UserProduct;

import java.util.Set;

public class ProductDAOImpl implements ProductDAO {
	Set<UserProduct> setProduct;
	@Override
	public boolean addProduct(UserProduct bean) {
		setProduct=new HashSet<UserProduct>();
		setProduct.add(bean);
		return true;
	}

	@Override
	public boolean deleteProduct(int productId, Map<Integer,Set<UserProduct>> map) {
		 Set<Entry<Integer,Set<UserProduct>>> entries=map.entrySet();
		 for (Entry<Integer, Set<UserProduct>> entry : entries) {
			if(entry.getKey()==productId) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Set<UserProduct> getProduct() {
		return setProduct;
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
