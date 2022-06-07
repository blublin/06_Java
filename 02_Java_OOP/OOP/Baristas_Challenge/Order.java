import java.util.ArrayList;
public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    // Constructors
    public Order() {
        name = "Guest";
        items = new ArrayList<Item>();
    }
    public Order(String name) {
        this.name = name;
        items = new ArrayList<Item>();
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setReady(boolean ready) {
        this.ready = ready;
    }
    public void addItem(Item oneItem) {
        items.add(oneItem);
    }
    public void addItems(Item... items) {
        for (Item item : items) {
            this.items.add(item);
        }
    }

    // Public Order Methods
    public String getStatusMessage() {
        if (ready) {
            String checkout = String.format(
                "Your order is ready!\nThat'll be $%.2f.",
                calculateTotal()
            );
            return checkout;
        }
        else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }
    public void display() {
        // Find longest string in menu
        int longest = 0;
        for (Item item : items) {
            if (item.getName().length() > longest) {
                longest = item.getName().length();
            }
        }

        System.out.println("\nCustomer Name: " + name);
        for (Item item: items) {
            System.out.printf("%-" + longest + "s - $%.2f\n",
            item.getName(), item.getPrice());
        }
        System.out.printf("Total: $%.2f\n\n", calculateTotal());
    }

    // Private Order Methods
    private double calculateTotal() {
        double total = 0.0;
        for (Item item : this.items) {
            total += item.getPrice();
        }
        return total;
    }
    

    // Getters
    public String getName() {
        return name;
    }
    public boolean isReady() {
        return ready;
    }
    public ArrayList<Item> getOrderItems() {
        return items;
    }

}