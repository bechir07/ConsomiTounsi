package tn.esprit.spring.Repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;



@Repository
public interface UserRepository extends JpaRepository <User, Long> {
	public User findByUsername(String username);


}

