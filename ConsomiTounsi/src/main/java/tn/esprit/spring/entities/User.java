package tn.esprit.spring.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int id ;
private String FirstName ;
private String LastName ;
private String email ;
private String Adress ;
private String login ;
private String password ;
@Transient
private String passwordConfirm;
private long phone ;
@Temporal (TemporalType.DATE)
private Date InscriptionDate;
@Enumerated(EnumType.STRING)
Role role;

@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
private Set<Product> products;
@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
private Set<Rating> ratings;
@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
private Set<Coupon> coupons;
@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
private Set<Add> adds;
@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
private Set<ADDView> views;
//@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
//private Set<Reclamation> reclamations;
//@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
//private Set<Comment> comments;

@Override
public String toString() {
	return "User [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", email=" + email + ", Adress="
			+ Adress + ", login=" + login + ", password=" + password + ", passwordConfirm=" + passwordConfirm
			+ ", phone=" + phone + ", InscriptionDate=" + InscriptionDate + ", role=" + role + ", products=" + products
			+ ", ratings=" + ratings + ", coupons=" + coupons + ", adds=" + adds + ", views=" + views + ", donations="
			+ donations + ", participations=" + participations + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAdress() {
	return Adress;
}
public void setAdress(String adress) {
	Adress = adress;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPasswordConfirm() {
	return passwordConfirm;
}
public void setPasswordConfirm(String passwordConfirm) {
	this.passwordConfirm = passwordConfirm;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public Date getInscriptionDate() {
	return InscriptionDate;
}
public void setInscriptionDate(Date inscriptionDate) {
	InscriptionDate = inscriptionDate;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public Set<Product> getProducts() {
	return products;
}
public void setProducts(Set<Product> products) {
	this.products = products;
}
public Set<Rating> getRatings() {
	return ratings;
}
public void setRatings(Set<Rating> ratings) {
	this.ratings = ratings;
}
public Set<Coupon> getCoupons() {
	return coupons;
}
public void setCoupons(Set<Coupon> coupons) {
	this.coupons = coupons;
}
public Set<Add> getAdds() {
	return adds;
}
public void setAdds(Set<Add> adds) {
	this.adds = adds;
}
public Set<ADDView> getViews() {
	return views;
}
public void setViews(Set<ADDView> views) {
	this.views = views;
}
/*
public Set<Reclamation> getReclamations() {
	return reclamations;
}
public void setReclamations(Set<Reclamation> reclamations) {
	this.reclamations = reclamations;
}*/
/*
public Set<Comment> getComments() {
	return comments;
}
public void setComments(Set<Comment> comments) {
	this.comments = comments;
}*/
public User(String firstName, String lastName, String email, String adress, String login, String password,
		String passwordConfirm, long phone, Date inscriptionDate, Role role) {
	super();
	FirstName = firstName;
	LastName = lastName;
	this.email = email;
	Adress = adress;
	this.login = login;
	this.password = password;
	this.passwordConfirm = passwordConfirm;
	this.phone = phone;
	InscriptionDate = inscriptionDate; 
	this.role = role;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}


@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
private Set<Donation> donations;

@OneToMany(cascade = CascadeType.ALL, mappedBy="userpr")
private Set<Participation> participations;
public Set<Donation> getDonations() {
	return donations;
}
public void setDonations(Set<Donation> donations) {
	this.donations = donations;
}
public Set<Participation> getParticipations() {
	return participations;
}
public void setParticipations(Set<Participation> participations) {
	this.participations = participations;
}




	


}
