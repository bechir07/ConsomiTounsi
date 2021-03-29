package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.entities.Product;


@Repository
public interface StockRepository extends CrudRepository <Stock, Integer> {
	@Query(value="SELECT p.id FROM product p,stock s  WHERE  p.stock_id = 1 and s.amount<10 ",nativeQuery=true)
	long missingProduct();
	

}
