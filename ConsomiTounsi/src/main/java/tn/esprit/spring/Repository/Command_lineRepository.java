package tn.esprit.spring.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.Command_line;
@Repository
public interface Command_lineRepository  extends JpaRepository<Command_line, Long>{
	/*/
	@Query("SELECT count(c.id) FROM Command_line c")
	long getNombreCommand_lineJPQL();
*/
	@Transactional
	@Modifying
	@Query(value="Update Command_line cl inner join Product p on cl.product_id=p.id set cl.total_product_price=cl.amount*p.price", nativeQuery = true)
    public int getQuntityIngredient(@Param("total_product_price") int product);
	@Transactional
	 @Modifying
	 @Query(value="Update command , Command_line set Command.total_price=(select SUM(total_product_price) from Command_line inner join command on Command_line.id=command.reference)", nativeQuery = true)
   public int getmonta(@Param("total_price") int p);

	/*
	@Query(value="select SUM(total_product_price) from Command_line", nativeQuery = true)
	  public int getmonta2();*/
}
