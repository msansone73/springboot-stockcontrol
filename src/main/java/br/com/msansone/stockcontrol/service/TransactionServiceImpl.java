package br.com.msansone.stockcontrol.service;

import br.com.msansone.stockcontrol.model.db.Transaction;
import br.com.msansone.stockcontrol.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository repository;
    @Override
    public List<Transaction> getAll() {
        return repository.findAll();
    }

    @Override
    public Transaction getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Transaction add(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public Transaction update(long id, Transaction transaction) throws Exception {
        Transaction transactionOld = this.getById(id);
        if (transactionOld==null){
            throw new Exception("Transacao inexistente");
        } else {
            transactionOld.setTransactionDate(transaction.getTransactionDate());
            transactionOld.setTransactionType(transaction.getTransactionType());
            transactionOld.setQuantity(transaction.getQuantity());
            transactionOld.setUnitaryValue(transaction.getUnitaryValue());
            repository.save(transactionOld);
            return transactionOld;
        }
    }


}
