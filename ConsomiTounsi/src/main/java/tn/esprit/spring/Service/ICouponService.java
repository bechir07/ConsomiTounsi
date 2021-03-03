package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Coupon;

public interface ICouponService {
	public Coupon addCoupon(Coupon c);

	public void deleteCoupon(int i);
	
	public List<Coupon> retrieveAllCoupons();
	
	public Coupon updateCoupon(Coupon c);

}
