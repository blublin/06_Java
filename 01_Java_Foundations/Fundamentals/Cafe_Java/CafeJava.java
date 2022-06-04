public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 1;
        double latte = 4;
        double cappuccino = 5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:

        // Customer 1
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        if (!isReadyOrder1) {
            System.out.println(customer1 + pendingMessage + "\n");
        }
        else if (isReadyOrder1) {
            System.out.println(customer1 + readyMessage);
            System.out.println(displayTotalMessage + dripCoffee + "\n");
        }

        // Customer 4
        System.out.println(generalGreeting + customer4);
        if (!isReadyOrder4) {
            System.out.println(customer4 + pendingMessage + "\n");
        }
        else if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappuccino + "\n");
        }

        // Customer 2
        System.out.println(generalGreeting + customer2); 
        if (!isReadyOrder2) {
            System.out.println(customer2 + pendingMessage + "\n");
        }
        else if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + latte * 2 + "\n"); // Math outside println? Math inside parenthesis?
        }

        // Customer 3
        System.out.println(generalGreeting + customer3);
        if (!isReadyOrder3) {
            System.out.println(customer3 + pendingMessage + "\n");
        }
        else if (isReadyOrder3) {
            System.out.println(customer3 + readyMessage);
            System.out.println(displayTotalMessage + (latte - dripCoffee) + ".\nWe're very sorry for the inconvenience!\n");
        }

    }
}
