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
	public float total_price;
	@Temporal(TemporalType.DATE)
	public Date order_date;

	
	@ManyToOne
    Delivery delivery;
	
	
	@ManyToOne
    Donation donation;
	
	@OneToOne(mappedBy="command")
	private Bill bill;
	
	@OneToMany(mappedBy="command", cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private List<Command_line> Command_line;
	@ManyToOne
	private User client;
	
	public int getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
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
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public Donation getDonation() {
		return donation;
	}
	public void setDonation(Donation donation) {
		this.donation = donation;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Command(int reference, float total_price, Date order_date, Delivery delivery, Donation donation, Bill bill,
			 User client) {
		super();
		this.reference = reference;
		this.total_price = total_price;
		this.order_date = order_date;
		this.delivery = delivery;
		this.donation = donation;
		this.bill = bill;
		this.client = client;
	}
	public Command(int reference, float total_price, Date order_date, Delivery delivery, Donation donation) {
		super();
		this.reference = reference;
		this.total_price = total_price;
		this.order_date = order_date;
		this.delivery = delivery;
		this.donation = donation;
	}
	public Command(int reference, float total_price, Date order_date) {
		super();
		this.reference = reference;
		this.total_price = total_price;
		this.order_date = order_date;
	}
	public Command(float total_price, Date order_date, Delivery delivery, Donation donation, Bill bill,
			 User client) {
		super();
		this.total_price = total_price;
		this.order_date = order_date;
		this.delivery = delivery;
		this.donation = donation;
		this.bill = bill;
		this.client = client;
	}
	@Override
	public String toString() {
		return "Command [reference=" + reference + ", total_price=" + total_price + ", order_date=" + order_date
				+ ", delivery=" + delivery + ", donation=" + donation + ", bill=" + bill + ", client=" + client + "]";
	}
	public List<Command_line> getCommand_line() {
		return Command_line;
	}
	public void setCommand_line(List<Command_line> command_line) {
		Command_line = command_line;
	}
	public Command() {
		super();
	}
	
	

	



	
	
	
}

