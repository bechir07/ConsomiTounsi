package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.esprit.spring.entities.Delivery;

@RepositoryRestResource(path = "Deliveries")
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{

}
