package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value="online_payment")
public class Online_payment extends Payment implements Serializable {

	private static final long serialVersionUID = -1396669830860400871L;

	
public int credit_card_number;


public int getCredit_card_number() {
	return credit_card_number;
}


public void setCredit_card_number(int credit_card_number) {
	this.credit_card_number = credit_card_number;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}


public Online_payment(int payment_id, Date payment_date, float total_price, Bill bill, int credit_card_number) {
	super(payment_id, payment_date, total_price, bill);
	this.credit_card_number = credit_card_number;
}


public Online_payment(int payment_id, Date payment_date, float total_price, Bill bill) {
	super(payment_id, payment_date, total_price, bill);
}




}
