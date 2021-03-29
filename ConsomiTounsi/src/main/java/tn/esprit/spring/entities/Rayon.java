package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Rayon implements Serializable {
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int id ;
private String TypeRayon;
@JsonIgnore
@OneToOne
private Category category;

public Rayon() {
	super();
}
public Rayon(String typeRayon,Category category) {
	super();
	TypeRayon = typeRayon;
	this.category=category;
}
public int getId() {
	return id;
}
public String getTypeRayon() {
	return TypeRayon;
}
public void setTypeRayon(String typeRayon) {
	TypeRayon = typeRayon;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}






}