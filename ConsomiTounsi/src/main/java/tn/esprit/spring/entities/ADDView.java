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
private int id;
@Temporal (TemporalType.DATE)
@Column(name="dateView")
private Date DateView;

@ManyToOne
@JoinColumn(name="idAdd", referencedColumnName="id" , insertable =false , updatable=false)
Add adds;
@ManyToOne
@JoinColumn(name="idUser", referencedColumnName="id" , insertable =false , updatable=false)
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
