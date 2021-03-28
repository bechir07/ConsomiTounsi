package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class LikeAdd implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	User user;
	
	@ManyToOne
	Add add;
	
	private boolean etat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Add getAdd() {
		return add;
	}

	public void setAdd(Add add) {
		this.add = add;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public LikeAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikeAdd(User user, Add add, boolean etat) {
		super();
		this.user = user;
		this.add = add;
		this.etat = etat;
	}

	public LikeAdd(Long id, User user, Add add, boolean etat) {
		super();
		this.id = id;
		this.user = user;
		this.add = add;
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "LikeAdd [id=" + id + ", user=" + user + ", add=" + add + ", etat=" + etat + "]";
	}
	
	
	
	

}
