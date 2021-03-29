package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Stock;



public interface IStockService {
	
	public int addStock(Stock s);
	public void deleteStock(int i);
	public Stock updateStock(Stock s);
	public List<Stock> getAllStocks();
	public long missingProduct();
	public void orderProduct(long pid,int amount);
	
	

}