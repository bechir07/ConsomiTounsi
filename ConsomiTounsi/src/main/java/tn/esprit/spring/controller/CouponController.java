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
	
	//http://localhost:8081/ConsomiTounsi/add-coupon
	@PostMapping("/add-coupon")
	@ResponseBody
	public Coupon addCoupon(@RequestBody Coupon c) 
	{
	return couponService.addCoupon(c);

	}
	
	//http://localhost:8081/ConsomiTounsi/retrieve-all-coupons
	@GetMapping(value ="/retrieve-all-coupons")
	@ResponseBody
	public List<Coupon> getCoupons() {

	return couponService.retrieveAllCoupons();

	} 
	
	//http://localhost:8081/ConsomiTounsi/remove-coupon/{id}
	@DeleteMapping("/remove-coupon/{id}")
	@ResponseBody
	public void removeCoupon(@PathVariable("id") Long id) {
	couponService.deleteCoupon(id);
	 }
	
	//http://localhost:8081/ConsomiTounsi/update-coupon
	@PutMapping("/update-coupon")
	@ResponseBody
	public Coupon modifyCoupon(@RequestBody Coupon c) {

		return couponService.addCoupon(c);

	}
	//http://localhost:8081/ConsomiTounsi/addCouponOnProduct/{productId}/{cId}
			    	@PostMapping("/addCouponOnProduct/{productId}/{cId}") 
			    	@ResponseBody 
			    	public void addCouponOnProduct(@PathVariable("productId")Long idProduct,@PathVariable("cId") Long cId) {
			    		couponService.addCouponToProduct(idProduct, cId);
			    	}
	
}
