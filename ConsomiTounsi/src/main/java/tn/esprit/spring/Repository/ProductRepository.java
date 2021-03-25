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

/*	public interface ProductRepository extends CrudRepository <Product, Integer> {
	
 @Query("SELECT DISTINCT Product FROM Command_line ip "
				+ "join ip.Product p  "
				+" where ip.Product=p.id ")
	 public List<Command_line> GetIPlat();
	 
	 
	 @Query("SELECT DISTINCT id FROM Product ip "
				+ "join ip.Command_line i  "
				+" where Product=ip.id and "
				+ "i.id=:command_line")
	 public List<Product> GetIngreidnet(@Param("command_line") int command_line);
	 
	 
	 @Query("select ip.amount from Command_line ip "
	 
	 		 +"join ip.Product i  "
			+" where i.id=:product and " 
	 		 +"ip.id=:command_line" )
	    public double getQuntityIngredient(@Param("product") int product,@Param("command_line") int command_line);*/
	
public interface ProductRepository extends JpaRepository<Product, Long> {

}
