package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.BillRepository;
import tn.esprit.spring.Repository.Cash_on_deliveryRepository;
import tn.esprit.spring.Repository.CommandRepository;
import tn.esprit.spring.Repository.PaymentRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.entities.Cash_on_delivery;


@Service
public class Cash_on_deliveryServiceImpl implements ICash_on_delivery{

	@Autowired
	CommandRepository commandRepository;
	@Autowired
	BillRepository billRepository;
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	Cash_on_deliveryRepository cash_on_deliveryRepository;
			@Override
			public int addCash_on_delivery(Cash_on_delivery cash_on_delivery) {
				return cash_on_deliveryRepository.save(cash_on_delivery).getPayment_id();
			}
			
			
			@Override
			public List<Cash_on_delivery> getAllCash_on_delivery() {
				return(List<Cash_on_delivery>) (cash_on_deliveryRepository.findAll());
					}
			
			public Cash_on_delivery updateCash_on_delivery(Cash_on_delivery p) {
				
				return cash_on_deliveryRepository.save(p);
			
				

			}
		/*	
			@Override
			public void deleteById(int id_paiment) {
				
				paiement_livraisonRepository.deleteById(id_paiment );
			}*/
		}

