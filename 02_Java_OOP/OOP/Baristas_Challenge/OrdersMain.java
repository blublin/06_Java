import java.util.ArrayList;
public class OrdersMain {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item("Sammich", 7.50);
        System.out.println("\n|----- Item 1 -----|");
        System.out.printf("Name: %s || Price: %s\n", item1.getName(), item1.getPrice());

        Item item2 = new Item("Soda Pop", 1.25);
        System.out.println("\n|----- Item 2 -----|");
        System.out.printf("Name: %s || Price: %s\n", item2.getName(), item2.getPrice());

        Item item3 = new Item("Burger", 4.75);
        System.out.println("\n|----- Item 3 -----|");
        System.out.printf("Name: %s || Price: %s\n", item3.getName(), item3.getPrice());

        Item item4 = new Item("Hot Dog", 3.47);
        System.out.println("\n|----- Item 4 -----|");
        System.out.printf("Name: %s || Price: %s\n", item4.getName(), item4.getPrice());

        Item item5 = new Item("BBQ Chips", 0.75);
        System.out.println("\n|----- Item 5 -----|");
        System.out.printf("Name: %s || Price: %s\n", item5.getName(), item5.getPrice());

        Item item6 = new Item("Bottled Water", 1.00);
        System.out.println("\n|----- Item 6 -----|");
        System.out.printf("Name: %s || Price: %s\n", item6.getName(), item6.getPrice());


        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.setReady(false);
        order1.addItems(item1, item4, item2, item5);
        
        Order order2 = new Order();
        order2.setReady(false);
        order2.addItems(item5, item4, item2);
        // order2.addItem(item4);
        // order2.addItem(item2);

        Order order3 = new Order("Jimmy");
        order3.setReady(true);
        order3.addItem(item1);
        order3.addItem(item2);
        order3.addItem(item3);

        Order order4 = new Order("Noah");
        order4.setReady(true);
        order4.addItem(item1);
        order4.addItem(item5);
        order4.addItem(item6);

        Order order5 = new Order("Sam");
        order5.setReady(true);
        order5.addItem(item1);
        order5.addItem(item2);
        order5.addItem(item5);


        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("\nName: %s\n", order1.getName());
        System.out.printf("Ready: %s\n", order1.isReady());
        System.out.println("Display for Order 1 ::");
        order1.display();
        System.out.println(order1.getStatusMessage());

        System.out.printf("\nName: %s\n", order2.getName());
        System.out.printf("Ready: %s\n", order2.isReady());
        System.out.println("Display for Order 2 ::");
        order2.display();
        System.out.println(order2.getStatusMessage());

        System.out.printf("\nName: %s\n", order3.getName());
        System.out.printf("Ready: %s\n", order3.isReady());
        System.out.println("Display for Order 3 ::");
        order3.display();
        System.out.println(order3.getStatusMessage());

        System.out.printf("\nName: %s\n", order4.getName());
        System.out.printf("Ready: %s\n", order4.isReady());
        System.out.println("Display for Order 4 ::");
        order4.display();
        System.out.println(order4.getStatusMessage());
        
        System.out.printf("\nName: %s\n", order5.getName());
        System.out.printf("Ready: %s\n", order5.isReady());
        System.out.println("Display for Order 5 ::");
        order5.display();
        System.out.println(order5.getStatusMessage());
    }
}
