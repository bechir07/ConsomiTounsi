package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Online_payment;

public interface IOnline_payment {


	
	public int addOnline_payment(Online_payment online_payment);
	public List<Online_payment> getAllOnline_payment();
	public Online_payment updateOnline_payment(Online_payment p);

}
