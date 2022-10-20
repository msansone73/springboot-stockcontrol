package br.com.msansone.stockcontrol.service;

import br.com.msansone.stockcontrol.model.db.Stock;
import br.com.msansone.stockcontrol.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    StockRepository repository;

    @Override
    public List<Stock> getAll() {
        return repository.findAll();
    }

    @Override
    public Stock insert(Stock stock) {
        return repository.save(stock);
    }

    @Override
    public Stock getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Stock update(long id, Stock stockNew) throws Exception {
        Stock stock = this.getById(id);
        if (stock==null){
            throw new Exception("Stock not found!");
        } else{
            stock.setName(stockNew.getName());
            stock.setTicker(stockNew.getTicker());
            stock.setStockType(stockNew.getStockType());
            repository.save(stock);
            return stock;
        }    }

    @Override
    public void delete(long id) {
        Stock stock=this.getById(id);
        if (stock!=null){
            repository.delete(stock);
        }
    }
}
