package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Chariot implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	
	private float totalp;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="chariot")
	private Set<DonChariot> donchariots;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy="chariotev")
	private Event event;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getTotalp() {
		return totalp;
	}

	public void setTotalp(float totalp) {
		this.totalp = totalp;
	}

	public Set<DonChariot> getDonchariots() {
		return donchariots;
	}

	public void setDonchariots(Set<DonChariot> donchariots) {
		this.donchariots = donchariots;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Chariot(int id, String description, float totalp, Set<DonChariot> donchariots, Event event) {
		super();
		this.id = id;
		this.description = description;
		this.totalp = totalp;
		this.donchariots = donchariots;
		this.event = event;
	}

	@Override
	public String toString() {
		return "Chariot [id=" + id + ", description=" + description + ", totalp=" + totalp + ", donchariots="
				+ donchariots + ", event=" + event + "]";
	}
	
	
	

}
