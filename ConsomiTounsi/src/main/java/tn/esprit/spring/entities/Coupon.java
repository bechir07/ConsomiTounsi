package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Coupon implements Serializable {
	
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int id ;
private String Code ;
private double Promo ;

@ManyToOne
//@JoinColumn(name="idProduct", referencedColumnName="id" , insertable =false , updatable=false)
Product product;

@ManyToOne
User users ;

@Override
public String toString() {
	return "Coupon [id=" + id + ", Code=" + Code + ", Promo=" + Promo + "]";
}

public Coupon(int id, String code, double promo) {
	super();
	this.id = id;
	Code = code;
	Promo = promo;
}

public Coupon() {
	super();
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCode() {
	return Code;
}

public void setCode(String code) {
	Code = code;
}

public double getPromo() {
	return Promo;
}

public void setPromo(double promo) {
	Promo = promo;
}

public Product getProducts() {
	return product;
}

public void setProducts(Product products) {
	this.product = products;
}


}
