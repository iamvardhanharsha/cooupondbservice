package com.harsha.coupondbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harsha.coupondbservice.bean.CouponEntity;

@Repository
public interface CouponRepository extends JpaRepository<CouponEntity, String> {

}
