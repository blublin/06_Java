import java.util.ArrayList;
public class OrdersMain {
    public static void main(String[] args) {
    
        CoffeeKiosk kiosk1 = new CoffeeKiosk();
        // Menu items
        kiosk1.addMenuItem("Sammich", 7.50);
        kiosk1.addMenuItem("Soda Pop", 1.25);
        kiosk1.addMenuItem("Burger", 4.75);
        kiosk1.addMenuItem("Hot Dog", 3.47);
        kiosk1.addMenuItem("BBQ Chips", 0.75);
        kiosk1.addMenuItem("Bottled Water", 1.00);

        kiosk1.newOrder();
        kiosk1.newOrder();

        kiosk1.addMenuItemByInput();
        
        kiosk1.newOrder();
    }
}
