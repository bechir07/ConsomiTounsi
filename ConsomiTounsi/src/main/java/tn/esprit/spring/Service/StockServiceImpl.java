package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.StockRepository;
import tn.esprit.spring.entities.Stock;



@Service
public class StockServiceImpl implements IStockService {
	@Autowired
	private StockRepository stockRepository;

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
		List<Stock> Stocks = (List<Stock>) stockRepository.findAll();	
		return Stocks;
	}

	

}

