package com.harsha.coupondbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableSwagger2
public class CoupondbserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoupondbserviceApplication.class, args);
	}

}
