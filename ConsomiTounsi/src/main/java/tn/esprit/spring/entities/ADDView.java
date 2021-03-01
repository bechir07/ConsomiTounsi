package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ADDView implements Serializable{
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int id;
@Temporal (TemporalType.DATE)
private Date DateView;

@ManyToOne
Add adds;
@ManyToOne
User users ;

@Override
public String toString() {
	return "ADDView [id=" + id + ", DateView=" + DateView + "]";
}

public ADDView() {
	super();
	// TODO Auto-generated constructor stub
}

public ADDView(int id, Date dateView) {
	super();
	this.id = id;
	DateView = dateView;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Date getDateView() {
	return DateView;
}

public void setDateView(Date dateView) {
	DateView = dateView;
}

public Add getAdds() {
	return adds;
}

public void setAdds(Add adds) {
	this.adds = adds;
}


}
