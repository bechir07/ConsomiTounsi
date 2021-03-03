package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.esprit.spring.entities.Reclamation;

@RepositoryRestResource(path = "reclamations", collectionResourceRel = "reclamation")
public interface ReclamationRepository extends JpaRepository<Reclamation, Integer> {

}
