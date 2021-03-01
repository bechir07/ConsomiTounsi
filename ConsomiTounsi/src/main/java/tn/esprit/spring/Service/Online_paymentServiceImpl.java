package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.BillRepository;
import tn.esprit.spring.Repository.Cash_on_deliveryRepository;
import tn.esprit.spring.Repository.CommandRepository;
import tn.esprit.spring.Repository.Online_paymentRepository;
import tn.esprit.spring.Repository.PaymentRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.entities.Online_payment;

@Service
public class Online_paymentServiceImpl implements IOnline_payment {

	
		@Autowired
		CommandRepository commandRepository;
		@Autowired
		BillRepository billRepository;
		@Autowired
		PaymentRepository paymentRepository;
		@Autowired
		ProductRepository productRepository;
		@Autowired
		Online_paymentRepository online_paymentRepository;
		@Autowired
		Cash_on_deliveryRepository cash_on_deliveryRepository;
		@Override
		public int addOnline_payment(Online_payment online_payment) {
			return online_paymentRepository.save(online_payment).getPayment_id();
		}
		
		
		@Override
		public List<Online_payment> getAllOnline_payment() {
			return(List<Online_payment>) (online_paymentRepository.findAll());
				}
		@Override
		public Online_payment updateOnline_payment(Online_payment p) {
			
			return online_paymentRepository.save(p);
		
			

		}
		/*
		@Override
		public void deleteById(int id_paiment) {
			
			paiement_enligneRepository.deleteById(id_paiment );
		}*/
	}

