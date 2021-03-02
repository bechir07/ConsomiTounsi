package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Command implements Serializable {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int reference;
	//public int id_product;////
	//public int id_client;/////
	public int quantity;
	public String NamePoduct;
	public float total_price;
	@Temporal(TemporalType.DATE)
	public Date order_date;
	@Enumerated(EnumType.STRING)
	@Column(name="payment_type")
	public Payment_type payment_type;
	
	@ManyToOne
    Delivery delivery;
	
	
	@ManyToOne
    Donation donation;
	
	@OneToOne(mappedBy="command")
	private Bill bill;
	
	@OneToMany(mappedBy="command", cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private List<Product> product;

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public int getReference() {
		return reference;
	}

	public String getNamePoduct() {
		return NamePoduct;
	}

	public void setNamePoduct(String namePoduct) {
		NamePoduct = namePoduct;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Payment_type getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(Payment_type payment_type) {
		this.payment_type = payment_type;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	//livraison
	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Command(int reference, int quantity, float total_price, Date order_date, Payment_type payment_type,
			Bill bill, List<Product> product) {
		super();
		this.reference = reference;
		this.quantity = quantity;
		this.total_price = total_price;
		this.order_date = order_date;
		this.payment_type = payment_type;
		this.bill = bill;
		this.product = product;
	}

	public Command() {
		super();
	}

	public Command(int reference, int quantity, String namePoduct, float total_price, Date order_date,
			Payment_type payment_type, Bill bill, List<Product> product) {
		super();
		this.reference = reference;
		this.quantity = quantity;
		NamePoduct = namePoduct;
		this.total_price = total_price;
		this.order_date = order_date;
		this.payment_type = payment_type;
		this.bill = bill;
		this.product = product;
	}

	public Command(int reference, int quantity, String namePoduct, float total_price, Date order_date,
			Payment_type payment_type, Donation donation, Bill bill, List<Product> product) {
		super();
		this.reference = reference;
		this.quantity = quantity;
		NamePoduct = namePoduct;
		this.total_price = total_price;
		this.order_date = order_date;
		this.payment_type = payment_type;
		this.donation = donation;
		this.bill = bill;
		this.product = product;
	}
	



	
	
	
}

