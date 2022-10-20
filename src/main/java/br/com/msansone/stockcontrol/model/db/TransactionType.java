package br.com.msansone.stockcontrol.model.db;

public enum TransactionType {
    BUY(0),
    SALE(1);

    private int transactionType;

    public int getTransactionType() {
        return transactionType;
    }

    private TransactionType(int transactionType) {
        this.transactionType = transactionType;
    }
}
