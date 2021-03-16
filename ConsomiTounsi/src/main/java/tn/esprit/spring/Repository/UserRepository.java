package tn.esprit.spring.Repository;

<<<<<<< HEAD

=======
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> branch 'main' of https://github.com/bechir07/ConsomiTounsi.git
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;


@Repository
<<<<<<< HEAD
public interface UserRepository extends CrudRepository <User, Integer> {
	public User findByUsername(String username);
=======
public interface UserRepository extends JpaRepository <User, Integer> {
	@Query("SELECT e FROM User e WHERE e.email=:email and e.password=:password")
	public User getUserByEmailAndPassword(@Param("email")String login,
	@Param("password")String password);
>>>>>>> branch 'main' of https://github.com/bechir07/ConsomiTounsi.git
}
