package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Participation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Event evntpr;
	
	@ManyToOne
	private User userpr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Event getEvntpr() {
		return evntpr;
	}

	public void setEvntpr(Event evntpr) {
		this.evntpr = evntpr;
	}

	public User getUserpr() {
		return userpr;
	}

	public void setUserpr(User userpr) {
		this.userpr = userpr;
	}

	public Participation(int id, Event evntpr, User userpr) {
		super();
		this.id = id;
		this.evntpr = evntpr;
		this.userpr = userpr;
	}

	@Override
	public String toString() {
		return "Participation [id=" + id + ", evntpr=" + evntpr + ", userpr=" + userpr + "]";
	}

}
