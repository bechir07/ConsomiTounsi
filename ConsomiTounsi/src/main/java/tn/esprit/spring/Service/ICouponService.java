package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Coupon;

public interface ICouponService {
	public int addCoupon(Coupon c);

	public void deleteCoupon(int i);
	
	public List<Coupon> retrieveAllCoupons(int id);
	
	public Coupon updateCoupon(Coupon c);

}
