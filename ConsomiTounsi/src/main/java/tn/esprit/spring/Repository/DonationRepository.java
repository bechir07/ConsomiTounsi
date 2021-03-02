package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Donation;

@Repository
public interface DonationRepository extends CrudRepository <Donation, Integer> {

}
