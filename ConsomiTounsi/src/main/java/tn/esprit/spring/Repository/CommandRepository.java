package tn.esprit.spring.Repository;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Command;
@Repository
public interface CommandRepository extends CrudRepository<Command, Integer> {

	
	@Query("SELECT count(*) FROM Command u")
	 long getNombreCommandJPQL();
	
	// Afficher commande d'un commande passé en paramètre
	
	public Command findByReference(int reference);
	
	public void deleteByReference(int reference);

	
	@Query(value="SELECT COUNT(reference), order_date  FROM Command GROUP BY order_date", nativeQuery = true)
	   public List<Command> GetComByDate();
	@Transactional
	 @Modifying
	@Query(value="Update Command c inner join Command_line cl on cl.command_reference=c.reference set c.total_price = SUM(cl.total_product_price)", nativeQuery = true)
  public int getmonta(@Param("total_price") int total_price);
	@Query(value="SELECT user.id, first_name, last_name, name, price, amount,total_product_price,command.reference,order_date,command.total_price FROM user INNER JOIN command ON user.id = command.client_id INNER JOIN command_line ON command.reference = command_line.command_reference INNER JOIN product ON product.id = command_line.product_id ", nativeQuery = true)
	public List<?> getafficherC();
}
