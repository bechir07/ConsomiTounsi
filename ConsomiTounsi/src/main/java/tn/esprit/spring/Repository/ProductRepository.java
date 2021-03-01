package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.*;



@Repository
public interface ProductRepository extends CrudRepository <Product, Integer> {

}
