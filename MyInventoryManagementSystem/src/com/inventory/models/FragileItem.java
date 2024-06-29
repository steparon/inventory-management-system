package com.inventory.models;

import com.inventory.Category;

public class FragileItem extends InventoryItem{

    public FragileItem(String name, double price, String description, int quantity) {
        super(name, price, String.valueOf(Category.FRAGILE), description, quantity);
    }
}
