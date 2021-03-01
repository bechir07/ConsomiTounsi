package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Cash_on_delivery;

@Repository
public interface Cash_on_deliveryRepository extends CrudRepository<Cash_on_delivery, Integer> {

	
}
