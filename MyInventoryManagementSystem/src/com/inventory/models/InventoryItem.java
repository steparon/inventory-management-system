package com.inventory.models;

public class InventoryItem extends AbstractItem {

    private static int nextId = 0;
    private int itemId;
    private int quantity;

    public InventoryItem(String name, double price, String category, String description, int quantity) {
        super(name,price,category, description);
        this.itemId = nextId++;
        this.quantity = quantity;
    }

    public InventoryItem(String name, double price, int quantity) {
        super(name, price);
        this.itemId = nextId++;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Category: " + getCategory() + "\n" +
                "Price: " + getPrice() + "\n" +
                "Id: " + getItemId() + "\n" +
                "Quantity: " + getQuantity() + "\n";
    }
}
