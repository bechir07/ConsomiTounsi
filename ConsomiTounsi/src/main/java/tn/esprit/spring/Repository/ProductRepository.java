package tn.esprit.spring.Repository;
import java.util.List;

import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.*;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
