package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Bill implements Serializable{
	
	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public long bill_id;
	//public int id_client;////
	//public int id_livraison;//
	public float total_price;
	//public String id_produit;//
	@Enumerated(EnumType.STRING)
	@Column(name="state")
	public State state;
	@Enumerated(EnumType.STRING)
	@Column(name="payment_type")
	public Payment_type payment_type;
	@Temporal(TemporalType.DATE)
	public Date date_of_bill;
	
	@OneToOne
	private Command command;
	
	@OneToOne(mappedBy="bill")
	private Payment Payment;

	public long getBill_id() {
		return bill_id;
	}

	public void setBill_id(long bill_id) {
		this.bill_id = bill_id;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Payment_type getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(Payment_type payment_type) {
		this.payment_type = payment_type;
	}

	public Date getDate_of_bill() {
		return date_of_bill;
	}

	public void setDate_of_bill(Date date_of_bill) {
		this.date_of_bill = date_of_bill;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public Payment getPayment() {
		return Payment;
	}

	public void setPayment(Payment payment) {
		Payment = payment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Bill(long bill_id, float total_price, State state, Payment_type payment_type, Date date_of_bill,
			Command command, tn.esprit.spring.entities.Payment payment) {
		super();
		this.bill_id = bill_id;
		this.total_price = total_price;
		this.state = state;
		this.payment_type = payment_type;
		this.date_of_bill = date_of_bill;
		this.command = command;
		Payment = payment;
	}


	public Bill() {
		super();
	}

	@Override
	public String toString() {
		return "Bill [bill_id=" + bill_id + ", total_price=" + total_price + ", state=" + state + ", payment_type="
				+ payment_type + ", date_of_bill=" + date_of_bill + ", command=" + command + ", Payment=" + Payment
				+ "]";
	}
	
	

}
