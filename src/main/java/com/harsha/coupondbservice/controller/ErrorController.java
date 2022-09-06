package com.harsha.coupondbservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

	@RequestMapping("/errors")
	public String error() {
		return "error page";

	}
}
