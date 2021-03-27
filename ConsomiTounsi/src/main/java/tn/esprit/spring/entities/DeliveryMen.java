package tn.esprit.spring.entities;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "id")
public class DeliveryMen extends User {



    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean available;
    private float latitude;
    private float longitude;
    private float prime;
    @OneToMany( mappedBy="deliverMen")
    private List<Delivery> deliveries;
    
    


}