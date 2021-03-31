package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.Repository.StockRepository;
import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Stock;




@Service
public class StockServiceImpl implements IStockService {
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
    private JavaMailSender javaMailSender;

	@Override
	public int addStock(Stock s) {
		stockRepository.save(s);
		return s.getId();
	}

	@Override
	public void deleteStock(int i) {
		stockRepository.deleteById(i);
		
	}

	@Override
	public Stock updateStock(Stock s) {
		stockRepository.save(s);
		return s ;
	}

	@Override
	public List<Stock> getAllStocks() {
		sendEmail();
		
		List<Stock> Stocks = (List<Stock>) stockRepository.findAll();	
		return Stocks;
	}

	@Override
	public List<Long> missingProduct() {
		
		List<Long> products = (List<Long>) stockRepository.missingProduct();	
		
		return products;
	}
	
	
	public void orderProduct(long pid,int amount) {
		Product p = productRepository.findById(pid).get();
		
		p.getStock().setAmount(amount+p.getStock().getAmount());
		productRepository.save(p);
	}
	
	
void sendEmail() {
try
{
	String ch="";
	List<Product> prods=new ArrayList<Product>();
	List<Long> products =  (List<Long>) stockRepository.missingProduct();
	//Product p = productRepository.findById(products).get();
	System.out.println(products.size());
	 for (int i = 0; i < products.size(); i++) {
	      System.out.println(products.get(i));
	     long p= products.get(i);
	      Product product =productRepository.findById(p).get();
	      
	      prods.add(product);
	      
	    }
	
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("chadisassi@gmail.com", "chadi.sassi1@esprit.tn");

        msg.setSubject("Missing Product");
    //    msg.setText(" Reference :  "+p.getReference()+" \n Name :  "+ p.getName() + "\n amount : " +p.getStock().getAmount() );

        for(int i=0; i<prods.size(); i++)
        {  ch =ch + " Reference :  "+prods.get(i).getReference()+" \n Name :  "+prods.get(i).getName()+ "\n amount : "+prods.get(i).getStock().getAmount()+ " \n / \n  " ;
        System.out.println(prods.get(i));
        }
         msg.setText(ch);
         System.out.println(ch);

        javaMailSender.send(msg);
        
}
catch(Exception e) {
	
  System.out.println("erreur"+e);
}

    }
	

}

