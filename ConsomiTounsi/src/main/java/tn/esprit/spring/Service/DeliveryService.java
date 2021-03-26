package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.DeliveryMenRepository;
import tn.esprit.spring.Repository.DeliveryRepository;
import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.entities.DeliveryMen;

@Service
public class DeliveryService {
	DeliveryRepository deliveryRepository;
	DeliveryMenRepository deliveryMenRepository;

	@Autowired
	public DeliveryService(DeliveryRepository deliveryRepository, DeliveryMenRepository deliveryMenRepository) {
		super();
		this.deliveryRepository = deliveryRepository;
		this.deliveryMenRepository = deliveryMenRepository;
	}

	public Delivery addDelivery(Delivery d,Long DeliveryMenId) {
		d.setFrais(this.calculFrais(d));
		DeliveryMen dm = deliveryMenRepository.getOne(DeliveryMenId);
		dm.getDeliveries().add(d);
		d.setDeliverMen(dm);
		deliveryRepository.save(d);
		deliveryMenRepository.save(dm);
		
		return d;
	}

	public Delivery updateDelivery(Delivery d,Long DeliveryMenId) {
		d.setFrais(this.calculFrais(d));
		//DeliveryMen dmm = deliveryMenRepository.getOne(d.getDeliverMen().getId());
		//dmm.getDeliveries().remove(d);
		System.out.println("1 ===================>  "+d.toString());
		DeliveryMen dm = deliveryMenRepository.getOne(DeliveryMenId);
		dm.getDeliveries().add(d);
		d.setDeliverMen(dm);
		//System.out.println("===================>  "+d.toString());
		deliveryRepository.save(d);
		deliveryMenRepository.save(dm);
		
		return d;
	}
	
	public List<Delivery> allDelivriesByDeliveryMen(Long id){
		return deliveryRepository.allDelivriesByDeliveryMen(id);
	}

	
	//Calcul des frais suivant le lieu, poids de l’objet,moyen de transport...
	public float calculFrais(Delivery delivery) {
		float fraistt=delivery.getFrais();
		if (!(delivery.getAdresse().equals("Tunis")) ){
			fraistt+=10.0f;
		}
		if (delivery.getPoids()>10) {
			fraistt+=10.0f;
		}
		return fraistt;
	}
}
