package com.inventory;

import com.inventory.models.ElectronicsItem;
import com.inventory.models.InventoryItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    final String FILE_PATH = "src/com/inventory/items.txt";
    public List<InventoryItem> getAllItems() {
        List<InventoryItem> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length == 5) {
                    String name = fields[0].trim();
                    double price = Double.parseDouble(fields[1].trim());
                    String category = fields[2].trim();
                    String description = fields[3].trim();
                    int quantity = Integer.parseInt(fields[4].trim());

                    if (category.equalsIgnoreCase("electronics")) {
                        ElectronicsItem item = new ElectronicsItem(name, price, description, quantity);
                        items.add(item);
                    } else {
                        InventoryItem item = new InventoryItem(name, price, category, description, quantity);
                        items.add(item);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void listItems() {
        List<InventoryItem> items = getAllItems();
        for (InventoryItem item : items) {
            System.out.println(item.toString());
            System.out.println();
        }
    }
    public boolean removeByName(String name) {
        List<InventoryItem> items = getAllItems();
        boolean removed = items.removeIf(item -> item.getName().equalsIgnoreCase(name));

        if (removed) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
                for (InventoryItem item : items) {
                    writer.printf("%s, %.2f, %s, %s, %d%n",
                            item.getName(),
                            item.getPrice(),
                            item.getCategory().toLowerCase(),
                            item.getDescription(),
                            item.getQuantity());
                }
                System.out.println("The item has been removed successfully");
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return removed;
    }

    public void findByCategory(String category) {
        List<InventoryItem> allItems = getAllItems();
        List<InventoryItem> foundItems = new ArrayList<>();

        for (InventoryItem item : allItems) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                foundItems.add(item);

            }
        }

        for (InventoryItem item : foundItems) {
            System.out.println(item.toString());
            System.out.println();
        }

    }

}
