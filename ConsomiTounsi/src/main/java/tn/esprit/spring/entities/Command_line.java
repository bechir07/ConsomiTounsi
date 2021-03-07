package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Command_line implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public int id;
	public int amount;
	public float total_product_price;

	@ManyToOne
    Command command;
	@ManyToOne
    Product product;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getTotal_product_price() {
		return total_product_price;
	}
	public void setTotal_product_price(float total_product_price) {
		this.total_product_price = total_product_price;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Command_line [id=" + id + ", amount=" + amount + ", total_product_price=" + total_product_price
				+ ", command=" + command + ", product=" + product + "]";
	}
	public Command_line(int id, int amount, float total_product_price, Command command, Product product) {
		super();
		this.id = id;
		this.amount = amount;
		this.total_product_price = total_product_price;
		this.command = command;
		this.product = product;
	}
	public Command_line(int id, int amount, float total_product_price) {
		super();
		this.id = id;
		this.amount = amount;
		this.total_product_price = total_product_price;
	}
	public Command_line(int amount, float total_product_price) {
		super();
		this.amount = amount;
		this.total_product_price = total_product_price;
	}
	public Command_line(int amount, float total_product_price, Command command, Product product) {
		super();
		this.amount = amount;
		this.total_product_price = total_product_price;
		this.command = command;
		this.product = product;
	}
	public Command_line() {
		super();
	}

	
	
	
	
	

}
