package tn.esprit.spring.entities;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * 
 */
@Entity
@Data
public class Remboursement {

    /**
     * Default constructor
     */
    public Remboursement() {
    }

    public enum Currency {
        EUR, USD;
    }
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private int amount;
    private Currency currency;
    private String receipt_email;
    private String stripeToken;


}