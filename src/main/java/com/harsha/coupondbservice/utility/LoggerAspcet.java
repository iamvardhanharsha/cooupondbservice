package com.harsha.coupondbservice.utility;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspcet {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspcet.class);

	@Before(value = "execution(* com.harsha.coupondbservice..*.*(..))")
	public void addLogbefore(JoinPoint joinPoint) {

		String classname = joinPoint.getSignature().getDeclaringType().getName();
		String method = joinPoint.getSignature().getName();
		LOGGER.info("started before  class {}  method {}", classname, method);

	}

}
