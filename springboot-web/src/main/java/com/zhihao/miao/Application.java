package com.zhihao.miao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.zhihao.miao.bean.Product;
import com.zhihao.miao.web.Response;

/**
 * 调用方式
 * 服务提供的是什么服务，rest（http），web service, rpc
 * rest  RestTemplate，httpclient
 */
public class Application {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		
		Product product = new Product();
		product.setPname("苹果手机");
		product.setType("手机");
		product.setPrice(3599d);
		String resp2 = restTemplate.postForObject("http://localhost:8080/soa/product/add", null, String.class,product);
		System.out.println(resp2);
		
		
	}
}
