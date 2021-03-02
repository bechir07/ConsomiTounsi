package tn.esprit.spring.entities;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Delivery {

    /**
     * Default constructor
     */
    public Delivery() {
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String adresse;
    private boolean state;
    private float frais;
    private Date date;
    private float poids;
    @ManyToOne
    DeliveryMen deliverMen;
    @OneToMany( mappedBy="delivery",cascade = CascadeType.ALL)
    private List<Command> commands;




}