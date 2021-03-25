package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id ;
private String Name ;

@OneToMany(cascade = CascadeType.ALL, mappedBy="categorie")
private Set<Product> product;

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

public Set<Product> getProduct() {
	return product;
}

public void setProduct(Set<Product> products) {
	this.product = products;
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
