package com.inventory.models;

import com.inventory.contracts.*;

public abstract class AbstractItem implements Item, Categorizable, Breakable, Perishable, Sellable {

    private String name;

    private String description;

    private String category;

    private double price;


    public AbstractItem(String name,double price, String category, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;

    }

    public AbstractItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        if (description == null) {
            description = "No description has been found";
        }
        return description;
    }

    @Override
    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
        }
    }

    @Override
    public String getCategory() {
        if (category == null) {
            category = "Other";
        }
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;

    }

    @Override
    public boolean isBreakable() {
        return false;
    }

    @Override
    public boolean isSellable() {
        return true;
    }

    @Override
    public boolean isPerishable() {
        return false;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

}
