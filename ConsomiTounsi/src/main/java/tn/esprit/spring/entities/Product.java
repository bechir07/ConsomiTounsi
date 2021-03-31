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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@JoinColumn(name="idCategory", referencedColumnName="id" , insertable =true , updatable=true)
Category categorie;
@ManyToOne
//@JoinColumn(name="idStock", referencedColumnName="id" , insertable =false , updatable=false)
Stock stock;

@ManyToOne
@JoinColumn(name="idcoupon", referencedColumnName="id" , insertable =true , updatable=true)
Coupon coupon;
@JsonIgnore
@OneToMany( mappedBy="product",cascade = CascadeType.ALL)
private List<Rating> rating;
@JsonIgnore
@OneToMany(mappedBy="prod",cascade = CascadeType.ALL )
private List<Add> add;
@ManyToOne
<<<<<<< HEAD
@JoinColumn(name="idUser", referencedColumnName="id" , insertable =true , updatable=false)
=======
@JoinColumn(name="idUser", referencedColumnName="id" , insertable =false , updatable=false)
>>>>>>> branch 'main' of https://github.com/bechir07/ConsomiTounsi.git
User user ;
@OneToMany(mappedBy="product", cascade = {CascadeType.PERSIST,CascadeType.ALL})
private List<Command_line> Command_line;

@OneToOne
private Reparation reparation;


public Coupon getCoupon() {
	return coupon;
}


public void setCoupon(Coupon coupon) {
	this.coupon = coupon;
}


public Product(Long id, String description, String name, String image, double price, String reference, Date dateProd,
		Category categorie, Stock stock, Coupon coupon, List<Rating> rating, List<Add> add, User user,
		List<tn.esprit.spring.entities.Command_line> command_line, Reparation reparation) {
	super();
	this.id = id;
	Description = description;
	Name = name;
	Image = image;
	Price = price;
	this.reference = reference;
	DateProd = dateProd;
	this.categorie = categorie;
	this.stock = stock;
	this.coupon = coupon;
	this.rating = rating;
	this.add = add;
	this.user = user;
	Command_line = command_line;
	this.reparation = reparation;
}


@Override
public String toString() {
	return "Product [id=" + id + ", Description=" + Description + ", Name=" + Name + ", Image=" + Image + ", Price="
			+ Price + ", reference=" + reference + ", DateProd=" + DateProd + ", categorie=" + categorie + ", stock="
			+ stock + ", coupon=" + coupon + ", rating=" + rating + ", add=" + add + ", user=" + user
			+ ", Command_line=" + Command_line + ", reparation=" + reparation + "]";
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


public User getUser() {
	return user;
}

<<<<<<< HEAD
public void setUser(User users) {
	this.user = users;
=======
public void setUser(User user) {
	this.user = user;
>>>>>>> branch 'main' of https://github.com/bechir07/ConsomiTounsi.git
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

public List<Command_line> getCommand_line() {
	return Command_line;
}

public void setCommand_line(List<Command_line> command_line) {
	Command_line = command_line;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

<<<<<<< HEAD

=======
public Product(Long id, String description, String name, String image, double price, String reference, Date dateProd,
		Category categories, Stock stock, List<Coupon> coupon, List<Rating> ratings, List<Add> adds, User user,
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
	this.user = user;
	Command_line = command_line;
	
}
>>>>>>> branch 'main' of https://github.com/bechir07/ConsomiTounsi.git
public Reparation getReparation() {
	return reparation;
}

public void setReparation(Reparation reparation) {
	this.reparation = reparation;

}



}
