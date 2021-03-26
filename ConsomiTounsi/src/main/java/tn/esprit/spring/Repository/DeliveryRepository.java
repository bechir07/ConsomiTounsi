package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.esprit.spring.entities.Delivery;

@RepositoryRestResource(path = "Deliveries")
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{
	@Query(
			  value = "SELECT * FROM delivery WHERE deliver_men_id=?1", 
			  nativeQuery = true)
	public List<Delivery> allDelivriesByDeliveryMen(Long id);

}
