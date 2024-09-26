package org.example;

public class Client {
    private Broker broker;
    private String noClient;
    public void buyStock(Stock stock, Integer quantity) {
        Wallet wallet = broker.getWallets().get(noClient);
        wallet.buyStock(stock, quantity);
    }
}
