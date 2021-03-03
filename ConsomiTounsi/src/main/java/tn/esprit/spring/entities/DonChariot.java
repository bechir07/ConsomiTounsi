package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class DonChariot implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private float price;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="donchariot")
	private Set<Product> products;
	
	@ManyToOne
	private Chariot chariot;

	public Chariot getChariot() {
		return chariot;
	}

	public void setChariot(Chariot chariot) {
		this.chariot = chariot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public DonChariot(int id, float price, Set<Product> products) {
		super();
		this.id = id;
		this.price = price;
		this.products = products;
	}

	@Override
	public String toString() {
		return "DonChariot [id=" + id + ", price=" + price + ", products=" + products + ", chariot=" + chariot + "]";
	}

	public DonChariot() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
