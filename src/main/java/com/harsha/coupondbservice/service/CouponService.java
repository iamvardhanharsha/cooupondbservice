package com.harsha.coupondbservice.service;

import java.util.Optional;

import com.harsha.coupondbservice.bean.CouponEntity;

public interface CouponService {

	Optional<CouponEntity> getCoupon(String client);

	CouponEntity addCoupon(CouponEntity couponEntity);

}
