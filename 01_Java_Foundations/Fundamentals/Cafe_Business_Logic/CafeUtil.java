import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal() {
    // Sum and return consecutive weeks through 10
     int sum = 0;
     byte weeks = 0;
     while (weeks <= 10) {
         sum += weeks;
         weeks++;
     }   
     return sum;
    }
    // Ninja bonus method overload
    public int getStreakGoal(int numWeeks) {
    // Sum and return consecutive weeks through user-defined numWeeks
     int sum = 0;
     byte weeks = 0;
     while (weeks <= numWeeks) {
         sum += weeks;
         weeks++;
     }   
     return sum;
    }

    public double getOrderTotal(double[] prices) {
        // Sum and return all floating point values in array
        double orderTotal = 0;
        for (double itemPrice : prices) {
            orderTotal += itemPrice;
        }
        return orderTotal;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        // print index and element of passed in ArrayList
        for (byte i = 0; i < menuItems.size(); i++) {
            System.out.printf("%s %s\n", i, menuItems.get(i) );
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        // Does this modify the original list??
        // Prompt for input
        System.out.println("Please enter your name:");
        // Store terminal input as String
        String userName = System.console().readLine();
        // Print username back
        System.out.printf("Hello %s.\n", userName);
        // Print size of array indicating number of people ahead of user
        System.out.printf("There are %s people ahead of you.\n", customers.size());
        // Add user to customers
        customers.add(userName);
    }

    // Ninja Bonus 1
    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (byte quantity = 1; quantity <= maxQuantity; quantity++) {
            // Sensei bonus, formatting with %.2f for 2 decimal places 
            System.out.printf("%s - $%.2f\n",
            quantity, price * quantity
            );
        }
    }

    // Sempai Bonus
    public void printPriceChartWithDiscount(String product, double price, int maxQuantity) {
        double discountValue = 0.5;
        System.out.println(product);
        for (byte quantity = 1; quantity <= maxQuantity; quantity++) {
            // Sensei bonus, formatting with %.2f for 2 decimal places 
            System.out.printf("%s - $%.2f\n",
            quantity,
            // 50 cent discount for every additional order over 1
            (price * quantity) - (discountValue*(quantity-1))
            );
        }
    }

    // Ninja Bonus II
    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) return false;

        // Find longest string in menu
        int longest = 0;
        for (String item : menuItems) {
            if (item.length() > longest) {
                longest = item.length();
            }
        }

        for (byte i = 0; i < prices.size(); i++) {
            // https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
            // Left aligned spacing
            System.out.printf("%s %-" + longest + "s -- $%.2f\n",
            i, menuItems.get(i), prices.get(i)
            );
        }
        return true;
    }

}
