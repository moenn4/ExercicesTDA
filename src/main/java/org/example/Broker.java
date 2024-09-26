// src/main/java/org/example/Broker.java
package org.example;

import java.util.Map;

public class Broker {

    private final Map<String, Wallet> wallets;

    public Broker(Map<String, Wallet> wallets) {
        this.wallets = wallets;
    }

    public void buyStock(String customerNo, Stock stock, Integer quantity) {
        Wallet wallet = wallets.get(customerNo);
        wallet.buyStock(stock, quantity);
    }

    public void sellStock(String customerNo, Stock stock, int quantity) {
        Wallet wallet = wallets.get(customerNo);
        wallet.sellStock(stock, quantity);
    }

    public Map<String, Wallet> getWallets() {
        return this.wallets;
    }
}