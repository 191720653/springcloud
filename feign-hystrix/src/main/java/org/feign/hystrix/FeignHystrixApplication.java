package org.feign.hystrix;

import org.feign.hystrix.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * feign 方式调用服务
 * feign 声明式http客户端，集成robbin，实现负载均衡
 * 整合hystrix，实现熔断，服务降级
 * hystrix 当服务不可用达到阀值时，直接执行fallback方法返回，不用等到超时
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class FeignHystrixApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FeignHystrixApplication.class, args);
	}
	
	@Autowired
	private IHelloService iHelloService;
	
	@RequestMapping("/hello")
	public String hello(String name) {
		return iHelloService.hello(name);
	}
	
}