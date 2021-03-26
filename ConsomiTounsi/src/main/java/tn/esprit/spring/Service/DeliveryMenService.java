package tn.esprit.spring.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.DeliveryMenRepository;
import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.entities.DeliveryMen;

@Service
public class DeliveryMenService {
	@Autowired
	DeliveryMenRepository deliveryMenRepository;

     public Map<Long,Double> plusProcheDeliveryMen() {
		List<DeliveryMen> d = deliveryMenRepository.findAll();
		Map<Long,Double> c =new HashMap<>();
		
		for (DeliveryMen x : d) {
			c.put(x.getId(), this.calculateDistanceInMeters(x.getLatitude(), x.getLongitude(), 1000, 1500));
		}
		Map<Long,Double> sortedMap= c.entrySet()
                .stream()
                .sorted((Map.Entry.<Long, Double>comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return sortedMap;
	}
	 
	
	
	// day num 28 of every month
	@Scheduled(cron = "0 0 12 28 1/1  *")
	public void attributePrimeToDeliveryMen() {
		List<DeliveryMen> dm = deliveryMenRepository.findAll();
		dm.stream().forEach(x -> {
			x.setPrime(this.prime(x));
		});
		deliveryMenRepository.flush();
	}
	//Statistiques (livreur du mois) idLivreur , nbr livraison
	public HashMap<Long, Integer> stats(){
		HashMap<Long, Integer> tt = new HashMap<Long, Integer>();
		 int a=0;
		List<DeliveryMen> dm = deliveryMenRepository.findAll();
		for (DeliveryMen d : dm) {
			for (Delivery dd : d.getDeliveries()) {
				if( dd.getDate().getMonthValue()==Calendar.getInstance().get(Calendar.MONTH)+1) {
					a+=1;
				}
			}
			tt.put(d.getId(), a);
			a=0;
		}
		System.out.println("=========> "+tt.toString());
		return tt;
	}

	// chaque prime égale a 30dt + a chaque livraison on ajoute 5dt
	public float prime(DeliveryMen dm) {

		return 30 + (dm.getDeliveries().size() + 5F);
	}

	// calcul distance entre deux points 2010
	// static
	/*
	 * public double distance(double lat1, double lat2, double lon1, double lon2,
	 * double el1, double el2) {
	 * 
	 * final int R = 6371; // Radius of the earth
	 * 
	 * double latDistance = Math.toRadians(lat2 - lat1); double lonDistance =
	 * Math.toRadians(lon2 - lon1); double a = Math.sin(latDistance / 2) *
	 * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
	 * Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) *
	 * Math.sin(lonDistance / 2); double c = 2 * Math.atan2(Math.sqrt(a),
	 * Math.sqrt(1 - a)); double distance = R * c * 1000; // convert to meters
	 * 
	 * double height = el1 - el2;
	 * 
	 * distance = Math.pow(distance, 2) + Math.pow(height, 2);
	 * 
	 * return Math.sqrt(distance); }
	 */

	
	  public double calculateDistanceInMeters(double lat1, double long1, double
	  lat2, double long2) {
	  
	  
	  double dist = org.apache.lucene.util.SloppyMath.haversinMeters(lat1, long1,
	  lat2, long2); return dist; }
	  
	
}
