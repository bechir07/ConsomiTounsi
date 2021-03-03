package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.CouponServiceImpl;
import tn.esprit.spring.entities.Coupon;

@RestController
public class CouponController {

	@Autowired
	CouponServiceImpl couponService ;
	
	//http://localhost:8081/ConsomiTounsi/servlet/add-coupon
	@PostMapping("/add-coupon")
	@ResponseBody
	public Coupon addCoupon(@RequestBody Coupon c) 
	{
	return couponService.addCoupon(c);

	}
	
	//http://localhost:8081/ConsomiTounsi/servlet/retrieve-all-coupons
	@GetMapping(value ="/retrieve-all-coupons")
	@ResponseBody
	public List<Coupon> getCoupons() {

	return couponService.retrieveAllCoupons();

	} 
	
	//http://localhost:8081/ConsomiTounsi/servlet/remove-coupon/{id}
	@DeleteMapping("/remove-coupon/{id}")
	@ResponseBody
	public void removeCoupon(@PathVariable("id") int id) {
	couponService.deleteCoupon(id);
	 }
	
	//http://localhost:8081/ConsomiTounsi/servlet/update-coupon
	@PutMapping("/update-coupon")
	@ResponseBody
	public Coupon modifyCoupon(@RequestBody Coupon c) {

		return couponService.addCoupon(c);

	}
	
}
