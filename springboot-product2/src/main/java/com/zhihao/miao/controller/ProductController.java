package com.zhihao.miao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhihao.miao.bean.Product;
import com.zhihao.miao.service.ProductService;
import com.zhihao.miao.web.Response;

/**
 *  product rest 服务
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/soa/product/add")
	public Object add(@RequestBody Product product) {
		Integer res = productService.add(product);
		return res == 1 ? new Response("200", "OK") : new Response("500", "Fail");
	}
	
	@PutMapping("/soa/product/update")
	public Object update(@RequestBody Product product) {
		Integer res = productService.update(product);
		return res == 1 ? new Response("200", "OK") : new Response("500", "Fail");
	}
	
	@DeleteMapping("/soa/product/{id}")
	public Object delete(@PathVariable("id") Integer id) {
		Integer res = productService.deleteById(id);
		return res == 1 ? new Response("200", "OK") : new Response("500", "Fail");
	}
	
	@GetMapping("/soa/product/{id}")
	public Object get(@PathVariable("id") Integer id) {
		Product product = productService.getById(id);
		return new Response("200", "OK", product);
	}
	
	@GetMapping("/soa/products")
	public Object list() {
		return new Response("200", "OK", productService.queryByLists());
	}
}
