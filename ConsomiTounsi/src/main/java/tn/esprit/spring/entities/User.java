package tn.esprit.spring.entities;


import java.io.Serializable;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collection;
=======
import java.util.Date;
import java.util.List;
>>>>>>> branch 'main' of https://github.com/bechir07/ConsomiTounsi.git
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
<<<<<<< HEAD

=======
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
>>>>>>> branch 'main' of https://github.com/bechir07/ConsomiTounsi.git
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



import com.fasterxml.jackson.annotation.JsonProperty;







@Entity(name = "user")

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean actived;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles=new ArrayList<>();



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
@OneToMany(cascade = CascadeType.ALL, mappedBy="users",fetch = FetchType.EAGER)
private Set<Reclamation> reclamations;
@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
private Set<Comment> comments;
@OneToMany(cascade = CascadeType.ALL, mappedBy="users",fetch = FetchType.EAGER)
private Set<Exchange> exchanges;





@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", actived=" + actived + ", roles="
			+ roles + ", products=" + products + ", ratings=" + ratings + ", coupons=" + coupons + ", adds=" + adds
			+ ", views=" + views + ", reclamations=" + reclamations + ", comments=" + comments + ", donations="
			+ donations + ", participations=" + participations + "]";
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public boolean isActived() {
	return actived;
}
public void setActived(boolean actived) {
	this.actived = actived;
}
public Collection<Role> getRoles() {
	return roles;
}
public void setRoles(Collection<Role> roles) {
	this.roles = roles;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
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

public Set<Reclamation> getReclamations() {
	return reclamations;
}
public void setReclamations(Set<Reclamation> reclamations) {
	this.reclamations = reclamations;
}

public Set<Comment> getComments() {
	return comments;
}
public void setComments(Set<Comment> comments) {
	this.comments = comments;
}


<<<<<<< HEAD


public User(Long id, String username, String password, boolean actived, Collection<Role> roles, Set<Product> products,
		Set<Rating> ratings, Set<Coupon> coupons, Set<Add> adds, Set<ADDView> views, Set<Reclamation> reclamations,
		Set<Comment> comments, Set<Donation> donations, Set<Participation> participations) {
=======
public Set<Exchange> getExchanges() {
	return exchanges;
}
public void setExchanges(Set<Exchange> exchanges) {
	this.exchanges = exchanges;
}


public User(String firstName, String lastName, String email, String adress, String login, String password,
		String passwordConfirm, long phone, Date inscriptionDate, Role role) {
>>>>>>> branch 'main' of https://github.com/bechir07/ConsomiTounsi.git
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.actived = actived;
	this.roles = roles;
	this.products = products;
	this.ratings = ratings;
	this.coupons = coupons;
	this.adds = adds;
	this.views = views;
	this.reclamations = reclamations;
	this.comments = comments;
	this.donations = donations;
	this.participations = participations;
}


public User() {
	super();
	// TODO Auto-generated constructor stub
}


@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
private Set<Donation> donations;

@OneToMany(cascade = CascadeType.ALL, mappedBy="userpr")
private Set<Participation> participations;
@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
private Set<Command> command;


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
public Set<Command> getCommand() {
	return command;
}
public void setCommand(Set<Command> command) {
	this.command = command;
}




	


}
