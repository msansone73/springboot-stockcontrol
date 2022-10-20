package br.com.msansone.stockcontrol.model.db;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String ticker;
    @Enumerated(EnumType.ORDINAL)
    private StockType stockType;

}
