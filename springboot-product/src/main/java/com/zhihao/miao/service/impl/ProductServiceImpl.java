package com.zhihao.miao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhihao.miao.bean.Product;
import com.zhihao.miao.mapper.ProductMapper;
import com.zhihao.miao.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;

	public Integer add(Product product) {
		return productMapper.add(product);
	}

	public Integer deleteById(Integer id) {
		return productMapper.deleteById(id);
	}

	public Integer update(Product product) {
		return productMapper.update(product);
	}

	public Product getById(Integer id) {
		return productMapper.getById(id);
	}

	public List<Product> queryByLists() {
		return productMapper.queryByLists();
	}
	
}
