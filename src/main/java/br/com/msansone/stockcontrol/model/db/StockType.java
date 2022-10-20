package br.com.msansone.stockcontrol.model.db;

public enum StockType {
    DEFAULT(0),
    FII(1);

    private int stockType;
    private StockType(int stockType) {
        this.stockType=stockType;
    }

    public int getStockType(){
        return this.stockType;
    }
}
