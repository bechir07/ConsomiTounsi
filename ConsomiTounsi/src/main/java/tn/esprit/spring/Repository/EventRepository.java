package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.User;

@Repository
public interface EventRepository extends CrudRepository <Event, Integer>{

	public Event findByName(String name);
	
	public Event findByLieu(String lieu);
}
