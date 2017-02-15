package com.zhihao.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.zhihao.miao.bean.Product;
import com.zhihao.miao.web.Response;

public class TestRestTemplate {
	
	private RestTemplate restTemplate;
	
	@Before
	public void init(){
		restTemplate = new RestTemplate();
	}

	@Test
	public void testGet() {
		String body = restTemplate.getForObject("http://localhost:8080/soa/products", String.class);
		System.out.println(body);
		Response resp = new Gson().fromJson(body, Response.class);
		System.out.println(resp);
	}
	
	@Test
	public void testPost(){
		Product product = new Product();
		product.setPname("苹果手机");
		product.setType("手机");
		product.setPrice(3599d);
		String resp = restTemplate.postForObject("http://localhost:8080/soa/product/add", product, String.class);
		System.out.println(resp);
	}
	
	@Test
	public void testPut(){
		Product product = new Product();
		product.setPname("苹果手机");
		product.setType("手机");
		product.setPrice(3444d);
		product.setPid(2);
		restTemplate.put("http://localhost:8080/soa/product/update", product);
	}
	
	@Test
	public void testDelete(){
		int id = 2;
		restTemplate.delete("http://localhost:8080/soa/product/{id}", id);
	}

}
