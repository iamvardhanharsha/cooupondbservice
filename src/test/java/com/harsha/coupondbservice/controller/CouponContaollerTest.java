package com.harsha.coupondbservice.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.harsha.coupondbservice.bean.CouponEntity;
import com.harsha.coupondbservice.service.CouponService;

@ExtendWith(MockitoExtension.class)
class CouponContaollerTest {
	@Mock
	CouponService couponService;
	@InjectMocks
	CouponContaoller contaoller;

	@Test
	final void testGetCoupon() throws InterruptedException {

		ResponseEntity<CouponEntity> response = contaoller.getCoupon("GPAY", "2344");

		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		Assertions.assertNull(response.getBody());

	}

	@Test
	final void testGetCouponsucess() throws InterruptedException {
		CouponEntity couponEntity = new CouponEntity();
		couponEntity.setClient("GPAY");
		couponEntity.setCouponCode("1234");
		couponEntity.setEndDate(new Date(2022, 9, 22));
		couponEntity.setStartDate(new Date(2022, 9, 22));

		Optional<CouponEntity> mockResponse = Optional.ofNullable(couponEntity);

		// when(couponService.getCoupon(any())).thenReturn(mockResponse);

		doReturn(mockResponse).when(couponService).getCoupon(any());

		ResponseEntity<CouponEntity> response = contaoller.getCoupon("GPAY", "2344");

		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertNotNull(response.getBody());

		verify(couponService, times(1)).getCoupon(any());

	}

}
