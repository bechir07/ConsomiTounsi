package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.DonChariot;

@Repository
public interface DonChariotRepository extends CrudRepository <DonChariot, Integer>{

}
