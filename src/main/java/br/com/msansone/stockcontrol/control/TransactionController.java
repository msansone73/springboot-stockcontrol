package br.com.msansone.stockcontrol.control;

import br.com.msansone.stockcontrol.model.db.Transaction;
import br.com.msansone.stockcontrol.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService service;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@PathVariable long id){
        Transaction transaction = service.getById(id);
        if (transaction==null){
            return ResponseEntity.notFound().build();
        } else {
            return  ResponseEntity.ok(transaction);
        }
    }

    @PostMapping
    public ResponseEntity<Transaction> add(@RequestBody Transaction transaction){
        return  ResponseEntity.ok(service.add(transaction));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Transaction> update(@PathVariable long id,
                                               @RequestBody Transaction transaction){
        try{
            Transaction transactionNew = service.update(id, transaction);
            return ResponseEntity.ok(transactionNew);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
