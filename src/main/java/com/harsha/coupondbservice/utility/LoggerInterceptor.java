package com.harsha.coupondbservice.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggerInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		MDC.put("apptoken", request.getHeader("AppToken"));
		LOGGER.info("Added token to MDC   App token {}", MDC.get("apptoken"));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {

		LOGGER.info("befrore clear  token to MDC   App token {}", MDC.get("apptoken"));
		MDC.clear();

		LOGGER.info("after clear  token to MDC   App token {}", MDC.get("apptoken"));

	}
}
