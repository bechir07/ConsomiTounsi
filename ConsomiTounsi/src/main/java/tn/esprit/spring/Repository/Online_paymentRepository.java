package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Online_payment;;

@Repository
public interface Online_paymentRepository extends CrudRepository<Online_payment, Integer>  {
	

}
