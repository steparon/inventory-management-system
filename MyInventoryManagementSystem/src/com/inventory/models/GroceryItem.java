package com.inventory.models;

import com.inventory.Category;

public class GroceryItem extends InventoryItem{

    public GroceryItem(String name, double price, String description, int quantity) {
        super(name, price, String.valueOf(Category.GROCERY), description, quantity);
    }

}
