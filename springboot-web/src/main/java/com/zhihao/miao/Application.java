package com.zhihao.miao;

import java.util.List;

import org.springframework.web.client.RestTemplate;

/**
 * 调用方式
 * 服务提供的是什么服务，rest（http），web service, rpc
 * rest  RestTemplate，httpclient
 */
public class Application {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject("http://localhost:8080/soa/products", List.class);
	}
}
