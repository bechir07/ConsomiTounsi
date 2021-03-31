package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id ;
private String Name ;
@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy="categorie")
private List<Product> product;

@Override
public String toString() {
	return "Category [id=" + id + ", Name=" + Name + ", product=" + product + "]";
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}



public List<Product> getProduct() {
	return product;
}

public void setProduct(List<Product> product) {
	this.product = product;
}

public Category() {
	super();
	
}

public Category(Long id, String name) {
	super();
	this.id = id;
	Name = name;
}


}
