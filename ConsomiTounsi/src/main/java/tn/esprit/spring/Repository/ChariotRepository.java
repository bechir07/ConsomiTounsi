package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Chariot;

@Repository
public interface ChariotRepository extends CrudRepository <Chariot, Integer> {

}
