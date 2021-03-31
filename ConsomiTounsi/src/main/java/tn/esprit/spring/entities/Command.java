package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.LocalDate;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.CreatedDate;



@Entity
public class Command implements Serializable {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long reference;
	//public int id_product;////
	//public int id_client;/////
	public float total_price;
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	public Payment_type type;
	public LocalDate order_date = LocalDate.now();

	
	@ManyToOne
    Delivery delivery;
	
	@JsonIgnore
	@ManyToOne
	private Chariot chariot;
	
	
	
	@OneToOne(mappedBy="command")
	private Bill bill;
	
	@OneToMany(mappedBy="command", cascade = {CascadeType.PERSIST,CascadeType.ALL})
	private List<Command_line> Command_line;
	@ManyToOne
	private User client;
	
	public long getReference() {
		return reference;
	}
	public void setReference(long reference) {
		this.reference = reference;
	}
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public LocalDate getOrder_date() {
		return order_date;
	}
	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
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
	public Command(int reference, float total_price, LocalDate order_date, Delivery delivery, Bill bill,
			 User client) {
		super();
		this.reference = reference;
		this.total_price = total_price;
		this.order_date = order_date;
		this.delivery = delivery;

		this.bill = bill;
		this.client = client;
	}
	public Command(int reference, float total_price, LocalDate order_date, Delivery delivery) {
		super();
		this.reference = reference;
		this.total_price = total_price;
		this.order_date = order_date;
		this.delivery = delivery;
		
	}
	public Command(int reference, float total_price, LocalDate order_date) {
		super();
		this.reference = reference;
		this.total_price = total_price;
		this.order_date = order_date;
	}
	public Command(float total_price, LocalDate order_date, Delivery delivery, Bill bill,
			 User client) {
		super();
		this.total_price = total_price;
		this.order_date = order_date;
		this.delivery = delivery;
		
		this.bill = bill;
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "Command [reference=" + reference + ", total_price=" + total_price + ", type=" + type + ", order_date="
				+ order_date + ", delivery=" + delivery + ", chariot=" + chariot + ", bill=" + bill + ", Command_line="
				+ Command_line + ", client=" + client + "]";
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
	public Chariot getChariot() {
		return chariot;
	}
	public void setChariot(Chariot chariot) {
		this.chariot = chariot;
	}
	public Command(long reference, float total_price, Payment_type type, LocalDate order_date, Delivery delivery,
			Chariot chariot, Bill bill, List<tn.esprit.spring.entities.Command_line> command_line, User client) {
		super();
		this.reference = reference;
		this.total_price = total_price;
		this.type = type;
		this.order_date = order_date;
		this.delivery = delivery;
		this.chariot = chariot;
		this.bill = bill;
		Command_line = command_line;
		this.client = client;
	}
	
	

	



	
	
	
}

