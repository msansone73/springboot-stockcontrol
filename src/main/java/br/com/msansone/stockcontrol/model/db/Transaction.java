package br.com.msansone.stockcontrol.model.db;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Stock stock;
    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType;
    private BigDecimal unitaryValue;
    private int quantity;
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

}
