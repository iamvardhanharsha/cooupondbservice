package com.harsha.coupondbservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsha.coupondbservice.bean.CouponEntity;
import com.harsha.coupondbservice.service.CouponService;

@RestController
@RequestMapping("/coupondb")
public class CouponContaoller {
	@Autowired
	CouponService couponService;

	@GetMapping("/getcoupon/{client}")
	public ResponseEntity<Optional<CouponEntity>> hai(@PathVariable(name = "client") String client,
			@RequestHeader(name = "AppToken") String appToken) {

		Optional<CouponEntity> couponEntity = couponService.getCoupon(client);

		MultiValueMap<String, String> hearder = new LinkedMultiValueMap<>();
		hearder.add("AppToken", appToken);
		ResponseEntity<Optional<CouponEntity>> response = new ResponseEntity<Optional<CouponEntity>>(couponEntity,
				hearder, HttpStatus.ACCEPTED);
		return response;
	}

}
