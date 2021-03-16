package tn.esprit.spring.Repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Command;
@Repository
public interface CommandRepository extends CrudRepository<Command, Integer> {

	/*
	@Query("SELECT count(u.reference) FROM Command u")
	 long getNombreCommandJPQL();
	*/
	// Afficher commande d'un commande passé en paramètre
	
	public Command findByReference(int reference);
	
	public void deleteByReference(int reference);

}
