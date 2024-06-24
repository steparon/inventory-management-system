package com.inventory.contracts;



public interface Sellable {

    boolean isSellable();
    double getPrice();
    void setPrice(double newPrice);
}
