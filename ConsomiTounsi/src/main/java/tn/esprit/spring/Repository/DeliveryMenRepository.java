package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.esprit.spring.entities.DeliveryMen;

@RepositoryRestResource(path = "DeliveryMen")
public interface DeliveryMenRepository extends JpaRepository<DeliveryMen, Long> {

}
