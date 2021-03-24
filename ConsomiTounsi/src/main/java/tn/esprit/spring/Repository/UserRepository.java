package tn.esprit.spring.Repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;


@Repository
public interface UserRepository extends CrudRepository <User, Integer> {
	//Optional<User> findBy(String login);
	//User findUserByUsername(String login);
	
	@Query("SELECT e FROM User e WHERE e.email=:email and e.password=:password")
	public User getUserByEmailAndPassword(@Param("email")String login,
	@Param("password")String password);
	
	
	
}
