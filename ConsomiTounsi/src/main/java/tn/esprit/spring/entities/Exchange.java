package tn.esprit.spring.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * 
 */
@Entity
@Data
public class Exchange {

 
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int numCoupon;

    private LocalDate dateLimite;

    private float couponValue;
    @ManyToOne()
    User users;
    public Exchange() {
    }


}