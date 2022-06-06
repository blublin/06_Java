import java.util.ArrayList;
public class OrdersMain {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        item1.name = "Sammich";
        item1.price = 7.50;
        System.out.println("\n|----- Item 1 -----|");
        System.out.printf("Name: %s || Price: %s\n", item1.name, item1.price);

        Item item2 = new Item();
        item2.name = "Soda Pop";
        item2.price = 1.25;
        System.out.println("\n|----- Item 2 -----|");
        System.out.printf("Name: %s || Price: %s\n", item2.name, item2.price);

        Item item3 = new Item();
        item3.name = "Burger";
        item3.price = 4.75;
        System.out.println("\n|----- Item 3 -----|");
        System.out.printf("Name: %s || Price: %s\n", item3.name, item3.price);

        Item item4 = new Item();
        item4.name = "Hot Dog";
        item4.price = 3.47;
        System.out.println("\n|----- Item 4 -----|");
        System.out.printf("Name: %s || Price: %s\n", item4.name, item4.price);

        Item item5 = new Item();
        item5.name = "BBQ Chips";
        item5.price = 0.75;
        System.out.println("\n|----- Item 5 -----|");
        System.out.printf("Name: %s || Price: %s\n", item5.name, item5.price);

        Item item6 = new Item();
        item6.name = "Bottled Water";
        item6.price = 1.00;
        System.out.println("\n|----- Item 6 -----|");
        System.out.printf("Name: %s || Price: %s\n", item6.name, item6.price);


        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.name = "Cindhuri";
        order1.ready = false;
        order1.items.add(item5);
        order1.items.add(item4);
        order1.items.add(item2);
        order1.total = order1.calculateTotal();

        Order order2 = new Order();
        order2.name = "Jimmy";
        order2.ready = true;
        order2.items.add(item1);
        order2.items.add(item2);
        order2.items.add(item3);
        order2.total = order2.calculateTotal();

        Order order3 = new Order();
        order3.name = "Noah";
        order3.ready = false;
        order3.items.add(item1);
        order3.items.add(item5);
        order3.items.add(item6);
        order3.total = order3.calculateTotal();

        Order order4 = new Order();
        order4.name = "Sam";
        order4.ready = false;
        order4.items.add(item1);
        order4.items.add(item2);
        order4.items.add(item5);
        order4.total = order4.calculateTotal();
        


        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("\nName: %s\n", order1.name);
        System.out.printf("Total: $%.2f\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("\nName: %s\n", order2.name);
        System.out.printf("Total: $%.2f\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);

        System.out.printf("\nName: %s\n", order3.name);
        System.out.printf("Total: $%.2f\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);

        System.out.printf("\nName: %s\n", order4.name);
        System.out.printf("Total: $%.2f\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}
