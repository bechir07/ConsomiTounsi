package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Cash_on_delivery;
import tn.esprit.spring.entities.*;

public interface ICash_on_delivery {


	public int addCash_on_delivery(Cash_on_delivery cash_on_delivery) ;

	//public void deleteById(int id_paiment);
	


	public List<Cash_on_delivery> getAllCash_on_delivery();
	public Cash_on_delivery updateCash_on_delivery(Cash_on_delivery p) ;


}
