package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
	@Transactional
	@Modifying
	@Query(value="Update Payment b inner join Bill c on b.bill_bill_id=c.bill_id set b.total_price=c.total_price", nativeQuery = true)
    public int getTotalPrace(@Param("total_price") int total_price);
	@Query(value="SELECT payment_id, user.id, username, bill_id, payment_date, product.name, product.price, amount, total_product_price, payment.total_price, payment.payment_type FROM user INNER JOIN command ON user.id = command.client_id INNER JOIN bill ON command.reference = bill.command_reference INNER JOIN command_line ON command.reference = command_line.command_reference INNER JOIN product ON product.id = command_line.product_id INNER JOIN payment ON bill.bill_id = payment.bill_bill_id ", nativeQuery = true)
	public List<?> getpaymentdetails();
	@Query(value="SELECT payment_id, user.id, username, bill_id, payment_date, product.name, product.price, amount, total_product_price, payment.total_price, payment.payment_type FROM user INNER JOIN command ON user.id = command.client_id INNER JOIN bill ON command.reference = bill.command_reference INNER JOIN command_line ON command.reference = command_line.command_reference INNER JOIN product ON product.id = command_line.product_id INNER JOIN payment ON bill.bill_id = payment.bill_bill_id where user.id=:id", nativeQuery = true)
	public List<?> getpaymentbyclient(@Param("id") long id);
	@Query(value="select * from payment c where c.payment_type=:payment_type", nativeQuery = true)
	public List<?> getpaymentByEtat(@Param("payment_type") String payment_type);
	@Query(value="SELECT payment_id, user.id, username, bill_id, payment_date, product.name, product.price, amount, total_product_price, payment.total_price, payment.payment_type FROM user INNER JOIN command ON user.id = command.client_id INNER JOIN bill ON command.reference = bill.command_reference INNER JOIN command_line ON command.reference = command_line.command_reference INNER JOIN product ON product.id = command_line.product_id INNER JOIN payment ON bill.bill_id = payment.bill_bill_id where product.name=:name", nativeQuery = true)
	public List<?> getpaymentbyproduct(@Param("name") String name);

}
