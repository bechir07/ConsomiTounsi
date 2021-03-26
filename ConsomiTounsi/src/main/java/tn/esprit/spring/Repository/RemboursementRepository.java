package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Remboursement;

@Repository
public interface RemboursementRepository extends JpaRepository<Remboursement, Integer> {

}
