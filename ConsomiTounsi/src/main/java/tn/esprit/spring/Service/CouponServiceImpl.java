package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.CouponRepository;
import tn.esprit.spring.Repository.ProductRepository;

import tn.esprit.spring.entities.Coupon;
import tn.esprit.spring.entities.Product;

@Service
public class CouponServiceImpl implements ICouponService {
	@Autowired
	private CouponRepository CouponRepository;
	@Autowired
	private ProductRepository ProductRepository;
	@Override
	public Coupon addCoupon(Coupon c) {
		CouponRepository.save(c);
		return c;
	}

	@Override
	public void deleteCoupon(Long i) {
		CouponRepository.deleteById(i);
		
	}

	@Override
	public List<Coupon> retrieveAllCoupons() {
		List<Coupon> coupons = (List<Coupon>) CouponRepository.findAll();	
		return coupons;
	}

	@Override
	public Coupon updateCoupon(Coupon c) {
		CouponRepository.save(c);
		return c;
	}
	
	@Override
	public String addCouponToProduct(Long productId, Long cId)
	{
		Coupon couponEntity = CouponRepository.findById(cId).get();
		Product productEntity = ProductRepository.findById(productId).get();

		if(couponEntity.getProduct() == null)
		{
			productEntity.setPrice(productEntity.getPrice()*couponEntity.getPromo());
			couponEntity.setProduct(productEntity);
			return "Coupon Added Successfully";

		}
		else
			return "Coupon already exsit on this product" ;
	}
	

}
