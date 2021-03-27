package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Donation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private double montant;
	
	@JsonIgnore
	@ManyToOne
	User user;
	
	@JsonIgnore
	@ManyToOne
	Jackpot jackpot;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Jackpot getJackpot() {
		return jackpot;
	}

	public void setJackpot(Jackpot jackpot) {
		this.jackpot = jackpot;
	}

	public Donation(int id, double montant, User user, Jackpot jackpot) {
		super();
		this.id = id;
		this.montant = montant;
		this.user = user;
		this.jackpot = jackpot;
	}

	@Override
	public String toString() {
		return "Donation [id=" + id + ", montant=" + montant + ", user=" + user + ", jackpot=" + jackpot + "]";
	}

	public Donation() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	
}
