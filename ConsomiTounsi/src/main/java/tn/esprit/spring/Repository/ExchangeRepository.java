package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.esprit.spring.entities.Exchange;

@RepositoryRestResource(path = "Exchange")
public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {
	
	@Query(
			  value = "SELECT * FROM exchange WHERE users_id= ?1", 
			  nativeQuery = true)
	public List<Exchange> getAllExchangeByUsersId(int id);
}
