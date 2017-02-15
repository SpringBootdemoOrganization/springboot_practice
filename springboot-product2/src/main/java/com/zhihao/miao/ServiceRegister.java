package com.zhihao.miao;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ServiceRegister implements ApplicationRunner {
	
	@Value("${zookeeper.address}")
	private String address;

	public void run(ApplicationArguments args) throws Exception {
		CuratorFramework client = CuratorFrameworkFactory.newClient(address, new RetryOneTime(1000));
		client.start();
		//直到连上为止
		client.blockUntilConnected();
		
		ServiceInstance<Object> serviceInstance = ServiceInstance.builder().name("product")
				.address("192.168.5.9").port(9090).build();
		
		ServiceDiscovery<Object> serviceDiscovery = ServiceDiscoveryBuilder.builder(Object.class).client(client).
				basePath("/soa").build();
		
		serviceDiscovery.registerService(serviceInstance);
		serviceDiscovery.start();
		System.out.println("service register ok!!!");
	}

}
