package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Event;


public interface EventRepository extends CrudRepository <Event, Integer>{

}
