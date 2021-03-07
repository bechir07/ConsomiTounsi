package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Participation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Event eventpr;
	
	@ManyToOne
	private User userpr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Event getEventpr() {
		return eventpr;
	}

	public void setEventpr(Event eventpr) {
		this.eventpr = eventpr;
	}

	public User getUserpr() {
		return userpr;
	}

	public void setUserpr(User userpr) {
		this.userpr = userpr;
	}

	public Participation(int id, Event eventpr, User userpr) {
		super();
		this.id = id;
		this.eventpr = eventpr;
		this.userpr = userpr;
	}

	@Override
	public String toString() {
		return "Participation [id=" + id + ", eventpr=" + eventpr + ", userpr=" + userpr + "]";
	}

	public Participation() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
