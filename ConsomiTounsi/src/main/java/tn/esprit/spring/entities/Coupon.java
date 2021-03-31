package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Coupon implements Serializable {
	
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id ;
private String Code ;
private double Promo ;


@ManyToOne
@JoinColumn(name="idUser", referencedColumnName="id" , insertable =true , updatable=false)
User user ;
@JsonIgnore
@OneToMany( mappedBy="coupon",cascade = CascadeType.ALL)
private List<Product> product;
@Override
public String toString() {
	return "Coupon [id=" + id + ", Code=" + Code + ", Promo=" + Promo + "]";
}

public List<Product> getProduct() {
	return product;
}

public void setProduct(List<Product> product) {
	this.product = product;
}

public Coupon(Long id, String code, double promo) {
	super();
	this.id = id;
	Code = code;
	Promo = promo;
}

public Coupon() {
	super();
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
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



public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}


}
