package com.harsha.coupondbservice.controller;

import java.util.Optional;

import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsha.coupondbservice.bean.CouponEntity;
import com.harsha.coupondbservice.service.CouponService;

@RestController
@RequestMapping("/coupondb")
@Validated
public class CouponContaoller {
	@Autowired
	CouponService couponService;
	private static final Logger LOGGER = LoggerFactory.getLogger(CouponContaoller.class);

	@GetMapping("/getcoupon/{client}")
	public ResponseEntity<Optional<CouponEntity>> getCoupon(
			@PathVariable(name = "client") @Pattern(regexp = "^[a-zA-Z]*$", message = "") String client,
			@RequestHeader(name = "AppToken") String appToken) throws InterruptedException {

		LOGGER.error("getCoupon method started  client: {}", client);
		LOGGER.info("getCoupon method   AppToken: {}", appToken);

		LOGGER.debug("00");
		Optional<CouponEntity> couponEntity = couponService.getCoupon(client);

		Thread.sleep(200);

		MultiValueMap<String, String> hearder = new LinkedMultiValueMap<>();
		hearder.add("AppToken", appToken);
		ResponseEntity<Optional<CouponEntity>> response = new ResponseEntity<Optional<CouponEntity>>(couponEntity,
				hearder, HttpStatus.ACCEPTED);

		return response;
	}

	@PostMapping("/addcoupon")
	public ResponseEntity<CouponEntity> addCoupon(@RequestBody CouponEntity couponEntity,
			@RequestHeader(name = "AppToken") String appToken) {

		CouponEntity couponEntityresult = couponService.addCoupon(couponEntity);

		MultiValueMap<String, String> hearder = new LinkedMultiValueMap<>();
		hearder.add("AppToken", appToken);
		ResponseEntity<CouponEntity> response = new ResponseEntity<CouponEntity>(couponEntityresult, hearder,
				HttpStatus.OK);
		return response;
	}

}
