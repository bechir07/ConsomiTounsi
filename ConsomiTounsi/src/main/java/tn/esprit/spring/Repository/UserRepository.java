package tn.esprit.spring.Repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;


@Repository
public interface UserRepository extends CrudRepository <User, Integer> {
	public User findByUsername(String username);
}
