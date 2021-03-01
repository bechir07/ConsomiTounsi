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
private int id ;
private String Name ;

@OneToMany(cascade = CascadeType.ALL, mappedBy="categories")
private Set<Product> products;

@Override
public String toString() {
	return "Category [id=" + id + ", Name=" + Name + "]";
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public Set<Product> getProducts() {
	return products;
}

public void setProducts(Set<Product> products) {
	this.products = products;
}

public Category() {
	super();
	
}

public Category(int id, String name) {
	super();
	this.id = id;
	Name = name;
}


}
