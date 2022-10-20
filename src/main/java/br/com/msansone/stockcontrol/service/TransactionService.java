package br.com.msansone.stockcontrol.service;

import br.com.msansone.stockcontrol.model.db.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAll();

    Transaction getById(long id);

    Transaction add(Transaction transaction);

    Transaction update(long id, Transaction transaction) throws Exception;
}
