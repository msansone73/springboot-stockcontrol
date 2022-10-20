package br.com.msansone.stockcontrol.control;

import br.com.msansone.stockcontrol.model.db.Stock;
import br.com.msansone.stockcontrol.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity<List<Stock>> getAll(){
        List<Stock> stocks = stockService.getAll();
        return ResponseEntity.ok(stocks);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Stock> getById(@PathVariable long id){
        Stock stock = stockService.getById(id);
        if (stock==null){
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(stock);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public  ResponseEntity<Stock> update(@PathVariable long id, @RequestBody Stock stockNew){
        try{
            Stock stock = stockService.update(id, stockNew);
            return ResponseEntity.ok(stock);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock){
        return ResponseEntity.ok(stockService.insert(stock));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteStock(@PathVariable long id){
        System.out.println("chegou ao public ResponseEntity deleteStock(@PathVariable long id)");
        stockService.delete(id);
        return ResponseEntity.ok().build();
    }
}
