package com.inventory.models;

import com.inventory.Category;

public class ElectronicsItem extends InventoryItem{
    public ElectronicsItem(String name, double price, String description, int quantity) {
        super(name, price, String.valueOf(Category.ELECTRONICS), description, quantity);
    }

}
