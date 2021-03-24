package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.esprit.spring.entities.Exchange;

@RepositoryRestResource(path = "Exchange")
public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {

}
