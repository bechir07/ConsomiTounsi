package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;

@Repository
public interface CouponRepository  extends JpaRepository <Coupon, Long>{

	
	@Query("select c FROM Coupon c where c.product = :product ")
	List<Product> retrieveCouponsOnProducts(@Param("product") Product product);
}
