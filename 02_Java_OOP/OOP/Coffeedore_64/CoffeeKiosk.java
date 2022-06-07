import java.util.ArrayList;
public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;
    public CoffeeKiosk() {
        menu = new ArrayList<Item>();
        orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price) {
        // Most efficient, but potentially unreliable
        int idx = menu.size();
        menu.add(new Item(name, price));
        menu.get(idx).setIndex(idx);

        // Reliable version
        // Item item = new Item(name, price);
        // menu.add(item);
        // int idx2 = menu.indexOf(item);
        // menu.get(idx2).setIndex(idx2);
    }

    public void displayMenu() {
        for (Item item : menu) {
            System.out.printf("%s %s -- $%.2f\n",
            item.getIndex(), item.getName(), item.getPrice());
        }
    }

    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Order order = new Order(name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();

    	// Prompts the user to enter an item number
        String menuPrompt = "Please enter a menu item index or q to quit:";
        System.out.println(menuPrompt);
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            
            // Get the item object from the menu, and add the item to the order
            Item item = menu.get(Integer.parseInt(itemNumber));
            order.addItem(item);
            // Ask them to enter a new item index or q again, and take their input
            System.out.println(menuPrompt);
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        order.display();
        
    }
    public void addMenuItemByInput() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("| ---- Please enter user credentials");
        System.out.printf("username: ");
        String userName = System.console().readLine();
        System.out.printf("password: ");
        System.console().readLine();
        System.out.println("\nWelcome " + userName);
        
        System.out.println("Would you like to enter a new item: (y to continue, anything else to finish)");
        String continueInput = System.console().readLine();
        
        while(continueInput.equals("y")) {
            
            System.out.printf("Enter new item name: ");
            String itemName = System.console().readLine();
            System.out.println();

            System.out.printf("Enter new item price: ");
            String itemPriceString = System.console().readLine();
            double itemPrice = Double.parseDouble(itemPriceString);
            System.out.println();

            addMenuItem(itemName, itemPrice);
            
            System.out.println("Would you like to enter a new item: (y to continue, anything else to finish)");
            continueInput = System.console().readLine();
        }
        System.out.println("|--- Modified Menu ---|");
        displayMenu();
    }
}