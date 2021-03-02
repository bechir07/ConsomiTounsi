package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Jackpot;

@Repository
public interface JackpotRepository extends CrudRepository <Jackpot, Integer> {

}
