package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
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
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="chariot")
	//private Set<DonChariot> donchariots;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="chariot")
	private Set<Command> Commands;
	
	@JsonIgnore
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

	

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Set<Command> getCommands() {
		return Commands;
	}

	public void setCommands(Set<Command> commands) {
		Commands = commands;
	}

	@Override
	public String toString() {
		return "Chariot [id=" + id + ", description=" + description + ", totalp=" + totalp + ", Commands=" + Commands
				+ ", event=" + event + "]";
	}

	public Chariot(int id, String description, float totalp, Set<Command> commands, Event event) {
		super();
		this.id = id;
		this.description = description;
		this.totalp = totalp;
		Commands = commands;
		this.event = event;
	}

	public Chariot() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	

}
