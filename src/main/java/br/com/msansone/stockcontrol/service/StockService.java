package br.com.msansone.stockcontrol.service;

import br.com.msansone.stockcontrol.model.db.Stock;

import java.util.List;

public interface StockService {
    List<Stock> getAll();

    Stock insert(Stock stock);

    Stock getById(long id);

    Stock update(long id, Stock stockNew) throws Exception;

    void delete(long id);
}
