package tn.esprit.spring.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * 
 */
@Entity
@Data
@org.hibernate.annotations.DiscriminatorOptions(force=true)
public class Exchange {

 
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int numCoupon;

    private LocalDate dateLimite;
    private String state;
    private float couponValue;
    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnore
    User users;
    public Exchange() {
    }


}