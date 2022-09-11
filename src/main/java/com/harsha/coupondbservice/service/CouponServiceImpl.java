package com.harsha.coupondbservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsha.coupondbservice.bean.CouponEntity;
import com.harsha.coupondbservice.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {
	@Autowired
	CouponRepository couponRepository;

	@Override
	public Optional<CouponEntity> getCoupon(String client) {

		return couponRepository.findById(client);

	}

	@Override
	public CouponEntity addCoupon(CouponEntity couponEntity) {

		return couponRepository.save(couponEntity);
	}

}
