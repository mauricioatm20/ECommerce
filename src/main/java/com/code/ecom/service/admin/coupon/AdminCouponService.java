package com.code.ecom.service.admin.coupon;

import com.code.ecom.entity.Coupon;

import java.util.List;

public interface AdminCouponService {

    Coupon createCoupon(Coupon coupon);

    List<Coupon> getAllCoupons();
}
