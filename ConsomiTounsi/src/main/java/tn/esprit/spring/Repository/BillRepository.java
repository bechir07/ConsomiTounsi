package tn.esprit.spring.Repository;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Bill;
import tn.esprit.spring.entities.Payment_type;
import tn.esprit.spring.entities.State;
@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

	List<Bill> findAll(Sort ascending);
	
	@Transactional
	@Modifying
	@Query(value="Update Bill b inner join Command c on b.command_reference=c.reference set b.total_price=c.total_price", nativeQuery = true)
    public int getTotalPrace(@Param("total_price") int total_price);
	@Query(value="select * from Bill c where c.payment_type=:payment_type", nativeQuery = true)
	public List<?> getbillByEtat(@Param("payment_type") String payment_type);
	@Query(value="SELECT id, username, bill_id, date_of_bill, bill.total_price FROM user INNER JOIN command ON user.id = command.client_id INNER JOIN bill ON command.reference = bill.command_reference ", nativeQuery = true)
	public List<?> getafficher();
	@Query(value="SELECT id, username, bill_id, date_of_bill, bill.total_price FROM user INNER JOIN command ON user.id = command.client_id INNER JOIN bill ON command.reference = bill.command_reference where command.client_id=:client_id", nativeQuery = true)
	public List<?> getbillbyclient(@Param("client_id") long client_id);
	@Query(value="SELECT id, username, bill_id, date_of_bill, bill.total_price FROM user INNER JOIN command ON user.id = command.client_id INNER JOIN bill ON command.reference = bill.command_reference where user.username=:username", nativeQuery = true)
	public List<?> getbillbyclientname(@Param("username") String username);
	
	


}
