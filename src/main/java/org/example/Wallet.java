package org.example;

import java.util.Map;

public class Wallet {

    private final Map<String, Integer> stocks;
    private double balance;

    public Wallet(Map<String, Integer> stocks, double balance) {
        this.stocks = stocks;
        this.balance = balance;
    }

    public Integer getStockQuantity(Stock stock) {
        return this.stocks.get(stock.getSymbol());
    }

    public void addStock(Stock stock, Integer quantity) {
        this.stocks.merge(stock.getSymbol(), quantity, Integer::sum);
    }

    public void removeStock(Stock stock, Integer quantity) {
        this.stocks.put(stock.getSymbol(), this.getStockQuantity(stock) - quantity);
    }

    public double getBalance() {
        return this.balance;
    }

    public void buyStock(Stock stock, Integer quantity) {
        double fees = calculateFees(quantity);
        double amount = stock.getCurrentPrice() * quantity + fees;
        payAmount(amount);
        addStock(stock, quantity);
    }

    public void sellStock(Stock stock, int quantity) {
        double fees = calculateFees(quantity);
        double amount = stock.getCurrentPrice() * quantity - fees;

        if (amount < 0 && Math.abs(amount) > this.balance) {
            throw new RuntimeException("Not enough funds");
        } else if (quantity > this.getStockQuantity(stock)) {
            throw new RuntimeException("Not enough stocks");
        } else {
            this.balance += amount;
            this.removeStock(stock, quantity);
        }
    }

    private double calculateFees(int quantity) {
        double smallFees = 0.05;
        double bigFees = 0.15;
        if (quantity < 100) {
            return smallFees * quantity;
        } else {
            return bigFees * quantity;
        }
    }
    private void payAmount(double amount) {
        if (amount > this.balance) {
            throw new RuntimeException("Not enough funds");
        } else {
            this.balance -= amount;
        }
    }
}