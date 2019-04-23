package org.ribbon.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * robbin + rest 方式调用服务
 * robbin 实现负载均衡调用服务，默认轮询
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableHystrix
public class RobbinRestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RobbinRestApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("hello")
	@HystrixCommand(fallbackMethod = "helloFallback")
	public String hello(String name) {
		return restTemplate.getForObject("http://EUREKA-CLIENT/hello?name=" + name, String.class);
	}
	
	public String helloFallback(String name) {
		return name + " sorry, something wrong";
	}
	
}
