package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Coupon;

public interface ICouponService {
	public Coupon addCoupon(Coupon c);

	public void deleteCoupon(Long i);
	
	public List<Coupon> retrieveAllCoupons();
	
	public Coupon updateCoupon(Coupon c);

}
