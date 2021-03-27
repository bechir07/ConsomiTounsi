package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Event implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	private String lieu;
	
	private int nbpart;
	

	@Temporal(TemporalType.DATE)
	private Date dateev;
	
	@JsonIgnore
	@ManyToMany
	private Set<User> usersevent;
	
	@JsonIgnore
	@OneToOne
	private Jackpot jackpotev;
	
	@JsonIgnore
	@OneToOne
	private Chariot chariotev;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Jackpot getJackpotev() {
		return jackpotev;
	}

	public void setJackpotev(Jackpot jackpotev) {
		this.jackpotev = jackpotev;
	}

	public Chariot getChariotev() {
		return chariotev;
	}

	public void setChariotev(Chariot chariotev) {
		this.chariotev = chariotev;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public int getNbpart() {
		return nbpart;
	}

	public void setNbpart(int nbpart) {
		this.nbpart = nbpart;
	}

	public Date getDateev() {
		return dateev;
	}

	public void setDateev(Date dateev) {
		this.dateev = dateev;
	}
	

	

	public Set<User> getUsersevent() {
		return usersevent;
	}

	public void setUsersevent(Set<User> usersevent) {
		this.usersevent = usersevent;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", description=" + description + ", lieu=" + lieu + ", nbpart="
				+ nbpart + ", dateev=" + dateev + ", usersevent=" + usersevent + ", jackpotev=" + jackpotev
				+ ", chariotev=" + chariotev + "]";
	}

	public Event(int id, String name, String description, String lieu, int nbpart, Date dateev, Set<User> usersevent,
			Jackpot jackpotev, Chariot chariotev) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.lieu = lieu;
		this.nbpart = nbpart;
		this.dateev = dateev;
		this.usersevent = usersevent;
		this.jackpotev = jackpotev;
		this.chariotev = chariotev;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
