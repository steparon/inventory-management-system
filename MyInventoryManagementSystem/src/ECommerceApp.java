import com.inventory.InventoryManager;


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
                    System.out.println("Please, type in the name of the product: ");
                    String name = sc.nextLine();
                    inventoryManager.removeByName(name);
                    break;
                case 3:
                    System.out.println("Type in name of the category: ");
                    String category = sc.nextLine();
                    inventoryManager.findByCategory(category);
                    break;
                case 4:
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
        System.out.println("2. Delete Item by Name");
        System.out.println("3. Find Items by Category");
        System.out.println("4. Exit");

    }
}