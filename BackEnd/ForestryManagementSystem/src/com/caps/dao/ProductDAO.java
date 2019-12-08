package com.caps.dao;

import java.util.Set;

import com.caps.userbean.dto.UserProduct;

public interface ProductDAO {
 public boolean addProduct(UserProduct bean);
 public boolean deleteProduct(int productId,UserProduct bean);
 public Set<UserProduct> getProduct();
 public boolean modifyProduct(int productId,UserProduct bean);
}
