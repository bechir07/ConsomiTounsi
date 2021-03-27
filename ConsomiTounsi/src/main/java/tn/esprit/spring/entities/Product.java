package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id ;
private String Description;
private String Name;
private String Image;
private double Price ;
private String reference ;
@Temporal (TemporalType.DATE)
@Column(name="dateProd")
private Date DateProd;

@ManyToOne
@JoinColumn(name="idCategory", referencedColumnName="id" , insertable =false , updatable=false)
Category categorie;
@ManyToOne
//@JoinColumn(name="idStock", referencedColumnName="id" , insertable =false , updatable=false)
Stock stock;

@OneToMany( mappedBy="product",cascade = CascadeType.ALL)
private List<Coupon> coupon;
@OneToMany( mappedBy="product",cascade = CascadeType.ALL)
private List<Rating> rating;
@OneToMany(mappedBy="prod",cascade = CascadeType.ALL )
private List<Add> add;
@ManyToOne
@JoinColumn(name="idUser", referencedColumnName="id" , insertable =false , updatable=false)
User user ;
@OneToMany(mappedBy="product", cascade = {CascadeType.PERSIST,CascadeType.ALL})
private List<Command_line> Command_line;

@OneToOne
private Reparation reparation;


@Override
public String toString() {
	return "Product [id=" + id + ", Description=" + Description + ", Name=" + Name + ", Image=" + Image + ", Price="
			+ Price + ", reference=" + reference + ", DateProd=" + DateProd + "]";
}

public Product() {
	super();
	
}


public Product(Long id, String description, String name, String image, double price, String reference, Date dateProd) {
	super();
	this.id = id;
	Description = description;
	Name = name;
	Image = image;
	Price = price;
	this.reference = reference;
	DateProd = dateProd;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
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

public Category getCategorie() {
	return categorie;
}

public void setCategorie(Category categorie) {
	this.categorie = categorie;
}






public List<Coupon> getCoupons() {
	return coupon;
}

public void setCoupons(List<Coupon> coupons) {
	this.coupon = coupons;
}

public User getUser() {
	return user;
}

public void setUser(User users) {
	this.user = users;
}

public List<Rating> getRating() {
	return rating;
}

public void setRating(List<Rating> ratings) {
	this.rating = ratings;
}

public List<Add> getAdd() {
	return add;
}

public void setAdd(List<Add> adds) {
	this.add = adds;
}




public Stock getStock() {
	return stock;
}

public void setStock(Stock stock) {
	this.stock = stock;
}

public List<Coupon> getCoupon() {
	return coupon;
}

public void setCoupon(List<Coupon> coupon) {
	this.coupon = coupon;
}

public List<Command_line> getCommand_line() {
	return Command_line;
}

public void setCommand_line(List<Command_line> command_line) {
	Command_line = command_line;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

public Product(Long id, String description, String name, String image, double price, String reference, Date dateProd,
		Category categories, Stock stock, List<Coupon> coupon, List<Rating> ratings, List<Add> adds, User users,
		List<tn.esprit.spring.entities.Command_line> command_line) {
	super();
	this.id = id;
	Description = description;
	Name = name;
	Image = image;
	Price = price;
	this.reference = reference;
	DateProd = dateProd;
	this.categorie = categories;
	this.stock = stock;
	this.coupon = coupon;
	this.rating = ratings;
	this.add = adds;
	this.user = users;
	Command_line = command_line;
	
}
public Reparation getReparation() {
	return reparation;
}

public void setReparation(Reparation reparation) {
	this.reparation = reparation;

}



}
