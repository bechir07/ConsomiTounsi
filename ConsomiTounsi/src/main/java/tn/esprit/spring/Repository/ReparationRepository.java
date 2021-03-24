package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.esprit.spring.entities.Reparation;

@RepositoryRestResource(path = "Exchange")
public interface ReparationRepository extends JpaRepository<Reparation, Integer> {

}
