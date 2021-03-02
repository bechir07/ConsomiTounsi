package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Participation;

@Repository
public interface ParticipationRepository extends CrudRepository <Participation, Integer> {

}
