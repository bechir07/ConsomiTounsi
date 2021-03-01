package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int id ;
private String Description;
private String Name;
private String Image;
private double Price ;
private String reference ;
@Temporal (TemporalType.DATE)
private Date DateProd;

@ManyToOne
Category categories;

@OneToMany( mappedBy="product",cascade = CascadeType.ALL)
private List<Coupon> coupon;
@OneToMany( mappedBy="product",cascade = CascadeType.ALL)
private List<Rating> ratings;
@OneToMany(mappedBy="prod",cascade = CascadeType.ALL )
private List<Add> adds;
@ManyToOne
User users ;
@ManyToOne
private Command command;

@Override
public String toString() {
	return "Product [id=" + id + ", Description=" + Description + ", Name=" + Name + ", Image=" + Image + ", Price="
			+ Price + ", reference=" + reference + ", DateProd=" + DateProd + "]";
}

public Product() {
	super();
	
}

public Command getCommand() {
	return command;
}

public void setCommand(Command command) {
	this.command = command;
}

public Product(int id, String description, String name, String image, double price, String reference, Date dateProd) {
	super();
	this.id = id;
	Description = description;
	Name = name;
	Image = image;
	Price = price;
	this.reference = reference;
	DateProd = dateProd;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDescription() {
	return Description;
}

public void setDescription(String description) {
	Description = description;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getImage() {
	return Image;
}

public void setImage(String image) {
	Image = image;
}

public double getPrice() {
	return Price;
}

public void setPrice(double price) {
	Price = price;
}

public String getReference() {
	return reference;
}

public void setReference(String reference) {
	this.reference = reference;
}

public Date getDateProd() {
	return DateProd;
}

public void setDateProd(Date dateProd) {
	DateProd = dateProd;
}

public Category getCategories() {
	return categories;
}

public void setCategories(Category categories) {
	this.categories = categories;
}






public List<Coupon> getCoupons() {
	return coupon;
}

public void setCoupons(List<Coupon> coupons) {
	this.coupon = coupons;
}

public User getUsers() {
	return users;
}

public void setUsers(User users) {
	this.users = users;
}

public List<Rating> getRatings() {
	return ratings;
}

public void setRatings(List<Rating> ratings) {
	this.ratings = ratings;
}

public List<Add> getAdds() {
	return adds;
}

public void setAdds(List<Add> adds) {
	this.adds = adds;
}




}
