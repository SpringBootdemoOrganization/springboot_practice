package com.zhihao.miao.service;

import java.util.List;

import com.zhihao.miao.bean.Product;

public interface ProductService {
	
	public Integer add(Product product);
	
	public Integer deleteById(Integer id);
	
	public Integer update(Product product);
	
	public Product getById(Integer id);
	
	public List<Product> queryByLists();

}
