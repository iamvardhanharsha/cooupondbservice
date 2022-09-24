package com.harsha.coupondbservice.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CouponServiceImplTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("before all");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		System.out.println("After all");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("before each");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After each");
	}

	@Test
	final void testCoupon() {
		CouponServiceImpl couponServiceImpl = new CouponServiceImpl();
		String resuponse = couponServiceImpl.coupon("hsghs");
		Assertions.assertNotNull(resuponse);
		Assertions.assertEquals("ALL25", resuponse);

	}

	@Test
	final void testnullCoupon() {
		CouponServiceImpl couponServiceImpl = new CouponServiceImpl();

		Assertions.assertThrows(NullPointerException.class, () -> {
			couponServiceImpl.coupon(null);
		});

	}

	@Test
	final void testemptyCoupon() {
		CouponServiceImpl couponServiceImpl = new CouponServiceImpl();

		Assertions.assertThrows(Exception.class, () -> {
			couponServiceImpl.coupon("");
		});

	}

	@Test
	final void testJioCoupon() {
		CouponServiceImpl couponServiceImpl = new CouponServiceImpl();
		String resuponse = couponServiceImpl.coupon("JIO");
		Assertions.assertNotNull(resuponse);
		Assertions.assertEquals("JIO20", resuponse);

	}

	@Test
	final void testErrorCoupon() {
		System.out.println("test error coupon");

	}

}
