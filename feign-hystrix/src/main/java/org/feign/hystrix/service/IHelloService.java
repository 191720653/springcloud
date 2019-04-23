package org.feign.hystrix.service;

import org.feign.hystrix.service.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "EUREKA-CLIENT", fallback = HelloServiceFallback.class)
public interface IHelloService {

	@RequestMapping("/hello")
	public String hello(@RequestParam(value = "name") String name);
	
}
