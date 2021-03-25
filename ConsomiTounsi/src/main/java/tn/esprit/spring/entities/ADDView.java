package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class ADDView implements Serializable{
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;
@Temporal (TemporalType.DATE)
@Column(name="dateView")
private Date DateView;

@ManyToOne
@JoinColumn(name="idAdd", referencedColumnName="id" , insertable =false , updatable=false)
Add add;
@ManyToOne
@JoinColumn(name="idUser", referencedColumnName="id" , insertable =false , updatable=false)
User user ;

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@Override
public String toString() {
	return "ADDView [id=" + id + ", DateView=" + DateView + ", add=" + add + ", user=" + user + "]";
}

public ADDView() {
	super();
	// TODO Auto-generated constructor stub
}

public ADDView(Long id, Date dateView) {
	super();
	this.id = id;
	DateView = dateView;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Date getDateView() {
	return DateView;
}

public void setDateView(Date dateView) {
	DateView = dateView;
}

public Add getAdd() {
	return add;
}

public void setAdd(Add add) {
	this.add = add;
}




}
