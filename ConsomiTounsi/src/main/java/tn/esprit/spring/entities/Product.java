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
private int id ;
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
Category categories;
@ManyToOne
//@JoinColumn(name="idStock", referencedColumnName="id" , insertable =false , updatable=false)
Stock stock;

@OneToMany( mappedBy="product",cascade = CascadeType.ALL)
private List<Coupon> coupon;
@OneToMany( mappedBy="product",cascade = CascadeType.ALL)
private List<Rating> ratings;
@OneToMany(mappedBy="prod",cascade = CascadeType.ALL )
private List<Add> adds;
@ManyToOne
@JoinColumn(name="idUser", referencedColumnName="id" , insertable =false , updatable=false)
User users ;
@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
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

@ManyToOne
//@JoinColumn(name="idDonChariot", referencedColumnName="id" , insertable =false , updatable=false)
DonChariot donchariot;

public DonChariot getDonchariot() {
	return donchariot;
}

public void setDonchariot(DonChariot donchariot) {
	this.donchariot = donchariot;
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

public Product(int id, String description, String name, String image, double price, String reference, Date dateProd,
		Category categories, Stock stock, List<Coupon> coupon, List<Rating> ratings, List<Add> adds, User users,
		List<tn.esprit.spring.entities.Command_line> command_line, DonChariot donchariot) {
	super();
	this.id = id;
	Description = description;
	Name = name;
	Image = image;
	Price = price;
	this.reference = reference;
	DateProd = dateProd;
	this.categories = categories;
	this.stock = stock;
	this.coupon = coupon;
	this.ratings = ratings;
	this.adds = adds;
	this.users = users;
	Command_line = command_line;
	this.donchariot = donchariot;
}
public Reparation getReparation() {
	return reparation;
}

public void setReparation(Reparation reparation) {
	this.reparation = reparation;

}



}
