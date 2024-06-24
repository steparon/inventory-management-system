import com.inventory.InventoryManager;
import com.inventory.models.ElectronicsItem;
import com.inventory.models.InventoryItem;


import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the E-commerce Console Application!");
        displayMenu();
        boolean isRunning = true;
        while(isRunning) {
            System.out.println("Enter command (1-4): ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    inventoryManager.listItems();
                    break;
                case 2:
                    System.out.println("Type in item's category: ");
                    String categoryToCreate = sc.nextLine();
                    System.out.println("Type in the product's name: ");
                    String name = sc.nextLine();
                    System.out.println("Type in the product's price" );
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.println("Describe the product: ");
                    String description = sc.nextLine();
                    System.out.println("How many products would you like to add?");
                    int quantity = Integer.parseInt(sc.nextLine());
                    if (categoryToCreate.equalsIgnoreCase("electronics")) {
                        ElectronicsItem item = new ElectronicsItem(name, price, description, quantity);
                        inventoryManager.addItem(item);
                    } else {
                        InventoryItem item = new InventoryItem(name, price, categoryToCreate, description, quantity);
                        inventoryManager.addItem(item);
                    }
                    break;
                case 3:
                    System.out.println("Please, type in the name of the product: ");
                    String nameToRemove = sc.nextLine();
                    inventoryManager.removeByName(nameToRemove);
                    break;
                case 4:
                    System.out.println("Type in name of the category: ");
                    String categoryToFind = sc.nextLine();
                    inventoryManager.findByCategory(categoryToFind);
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Exciting the application.");
                    break;
                default:
                    System.out.println("Invalid command.");


            }
        }
    }
    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. List Items");
        System.out.println("2. Add an Item");
        System.out.println("3. Delete an Item by Name");
        System.out.println("4. Find Items by Category");
        System.out.println("5. Exit");

    }
}