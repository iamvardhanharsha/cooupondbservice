package com.harsha.coupondbservice.controller;

import java.util.Optional;

import javax.validation.constraints.Pattern;

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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/coupondb")
@Validated
public class CouponContaoller {
	@Autowired
	CouponService couponService;
	CouponEntity couponEntity;

	@GetMapping("/getcoupon/{client}")
	public ResponseEntity<CouponEntity> getCoupon(
			@PathVariable(name = "client") @Pattern(regexp = "^[a-zA-Z]*$", message = "") String client,
			@RequestHeader(name = "AppToken") String appToken) throws InterruptedException {

		Optional<CouponEntity> couponEntityresponse = couponService.getCoupon(client);

		System.out.println(couponEntityresponse.toString());

		MultiValueMap<String, String> hearder = new LinkedMultiValueMap<>();
		hearder.add("AppToken", appToken);
		ResponseEntity<CouponEntity> response;
		if (couponEntityresponse.isEmpty()) {
			response = new ResponseEntity<CouponEntity>(couponEntity, hearder, HttpStatus.BAD_REQUEST);
		} else {
			couponEntity = couponEntityresponse.get();
			response = new ResponseEntity<CouponEntity>(couponEntity, hearder, HttpStatus.OK);
		}

		return response;
	}

	@PostMapping("/addcoupon")
	@ApiOperation(value = "addnewCoupon")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful retrieval", response = CouponEntity.class, responseContainer = "List")

	})

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
