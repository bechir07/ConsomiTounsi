package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.CouponRepository;
import tn.esprit.spring.entities.Coupon;


@Service
public class CouponServiceImpl implements ICouponService {
	@Autowired
	private CouponRepository CouponRepository;
	
	@Override
	public int addCoupon(Coupon c) {
		CouponRepository.save(c);
		return c.getId();
	}

	@Override
	public void deleteCoupon(int i) {
		CouponRepository.deleteById(i);
		
	}

	@Override
	public List<Coupon> retrieveAllCoupons(int id) {
		List<Coupon> coupons = (List<Coupon>) CouponRepository.findAll();	
		return coupons;
	}

	@Override
	public Coupon updateCoupon(Coupon c) {
		CouponRepository.save(c);
		return c;
	}

}
