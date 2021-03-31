package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "Pub")
public class Add implements Serializable {
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Temporal(TemporalType.DATE)
@Column(name="dateStart")
private Date DateStart;
@Temporal(TemporalType.DATE)
@Column(name="dateEnd")
private Date DateEnd;
@Column(name="priceSponsoring")
private double priceSponsoring ;
@Column(name="average")
private float average ;
@Column(name="Image")
private String Image ;
@Enumerated(EnumType.STRING)
TypeADD type;
@Column(name="name")
private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@ManyToOne
@JoinColumn(name="idProduct", referencedColumnName="id" , insertable =false , updatable=false)
Product prod;
@JoinColumn(name="idUser", referencedColumnName="id" , insertable =false , updatable=false)
@ManyToOne
User user ;
@OneToMany(cascade = CascadeType.ALL, mappedBy="add")
private Set<ADDView> view;
@OneToMany(cascade = CascadeType.ALL, mappedBy="add")
private List<LikeAdd> addlike;
@Override
public String toString() {
	return "Add [id=" + id + ", DateStart=" + DateStart + ", DateEnd=" + DateEnd + ", priceSponsoring="
			+ priceSponsoring + ", average=" + average + ", Image=" + Image + ", type=" + type + ", name=" + name
			+ ", prod=" + prod + ", user=" + user + ", view=" + view + "]";
}

public Add() {
	super();
	// TODO Auto-generated constructor stub
}

public Add(Long id, Date dateStart, Date dateEnd, double priceSponsoring, float average, String image, TypeADD type) {
	super();
	this.id = id;
	DateStart = dateStart;
	DateEnd = dateEnd;
	this.priceSponsoring = priceSponsoring;
	this.average = average;
	Image = image;
	this.type = type;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Date getDateStart() {
	return DateStart;
}

public void setDateStart(Date dateStart) {
	DateStart = dateStart;
}

public Date getDateEnd() {
	return DateEnd;
}

public void setDateEnd(Date dateEnd) {
	DateEnd = dateEnd;
}

public double getPriceSponsoring() {
	return priceSponsoring;
}

public void setPriceSponsoring(double priceSponsoring) {
	this.priceSponsoring = priceSponsoring;
}

public float getAverage() {
	return average;
}

public void setAverage(float average) {
	this.average = average;
}

public String getImage() {
	return Image;
}

public void setImage(String image) {
	Image = image;
}

public TypeADD getType() {
	return type;
}

public void setType(TypeADD type) {
	this.type = type;
}



public Product getProd() {
	return prod;
}

public void setProd(Product prod) {
	this.prod = prod;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Set<ADDView> getViews() {
	return view;
}

public void setViews(Set<ADDView> views) {
	this.view = view;
}

public List<LikeAdd> getAddlike() {
	return addlike;
}

public void setAddlike(List<LikeAdd> addlike) {
	this.addlike = addlike;
}


}
