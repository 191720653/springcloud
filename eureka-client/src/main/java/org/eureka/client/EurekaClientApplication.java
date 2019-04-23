package org.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * eureka 服务提供者
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClientApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	
	@Value("${server.port}")
	private int port;
	
	@RequestMapping("hello")
	public String hello(String name) {
		return port + "：hello world, " + name;
	}
	
}
