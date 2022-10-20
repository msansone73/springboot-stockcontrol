package br.com.msansone.stockcontrol.repository;

import br.com.msansone.stockcontrol.model.db.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
