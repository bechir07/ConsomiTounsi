package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Payment implements Serializable{


	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int payment_id;
	
	@Enumerated(EnumType.STRING)
	public Payment_type payment_type;
	@Enumerated(EnumType.STRING)

	public Payment_d_type payment_delivery_type;

	//public int id_produit;////
	//public int id_client;////
	@Temporal(TemporalType.DATE)
	public Date payment_date;
	public float total_price;
	
	
	public Payment() {
		super();
	}

	@OneToOne
	private Bill bill;

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Payment(int payment_id, Date payment_date, float total_price, Bill bill) {
		super();
		this.payment_id = payment_id;
		this.payment_date = payment_date;
		this.total_price = total_price;
		this.bill = bill;
	}



	
}
