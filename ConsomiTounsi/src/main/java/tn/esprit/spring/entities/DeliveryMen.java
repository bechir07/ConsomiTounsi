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

    @Override
	public String toString() {
		return "DeliveryMen [available=" + available + ", distance=" + distance + ", prime=" + prime + ", deliveries="
				+ deliveries + "]";
	}

	public DeliveryMen(Long id, String username, String password, boolean actived, Collection<Role> roles,
			Set<Product> products, Set<Rating> ratings, Set<Coupon> coupons, Set<Add> adds, Set<ADDView> views,
			Set<Reclamation> reclamations, Set<Comment> comments, Set<Donation> donations,
			Set<Participation> participations, boolean available, float distance, float prime,
			List<Delivery> deliveries) {
		super(id, username, password, actived, roles, products, ratings, coupons, adds, views, reclamations, comments,
				donations, participations);
		this.available = available;
		this.distance = distance;
		this.prime = prime;
		this.deliveries = deliveries;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public float getPrime() {
		return prime;
	}

	public void setPrime(float prime) {
		this.prime = prime;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DeliveryMen() {
    	super();
    }

}