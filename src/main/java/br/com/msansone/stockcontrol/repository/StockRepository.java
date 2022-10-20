package br.com.msansone.stockcontrol.repository;

import br.com.msansone.stockcontrol.model.db.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {



}
