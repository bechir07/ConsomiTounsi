package tn.esprit.spring.entities;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "id")
public class DeliveryMen extends User {



    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean available;
    private float distance;
    private float prime;
    @OneToMany( mappedBy="deliverMen",cascade = CascadeType.ALL)
    private List<Delivery> deliveries;

    private DeliveryMen() {
    }

}