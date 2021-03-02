package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value="cash_on_delivery")
public class Cash_on_delivery extends Payment implements Serializable {

	private static final long serialVersionUID = -1396669830860400871L;


	@Enumerated(EnumType.STRING)
	@Column(name="Payment_d_type")
	public Payment_d_type Payment_d_type;


	public Payment_d_type getPayment_d_type() {
		return Payment_d_type;
	}

	public void setPayment_d_type(Payment_d_type payment_d_type) {
		Payment_d_type = payment_d_type;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cash_on_delivery(int payment_id, Date payment_date, float total_price, Bill bill,
			tn.esprit.spring.entities.Payment_d_type payment_d_type) {
		super(payment_id, payment_date, total_price, bill);
		Payment_d_type = payment_d_type;
	}

	public Cash_on_delivery(int payment_id, Date payment_date, float total_price, Bill bill) {
		super(payment_id, payment_date, total_price, bill);
	}
	



}
