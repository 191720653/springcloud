package org.feign.hystrix.service.fallback;

import org.feign.hystrix.service.IHelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements IHelloService {

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return name + " sorry, something wrong";
	}

}
