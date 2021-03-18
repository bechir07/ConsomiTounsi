package tn.esprit.spring.entities;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * 
 */
@Entity
@Data
public class Reparation {

    /**
     * Default constructor
     */
    public Reparation() {
    }
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String typePanne;
    private float prixReparation;
    private String state;
    private LocalDate dateReparation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy="reparation",fetch = FetchType.EAGER)
    private Product product;


}