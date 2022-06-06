import java.util.ArrayList;
public class Order {
    public String name;
    public double total;
    public boolean ready;
    public ArrayList<Item> items = new ArrayList<Item>();

    public double calculateTotal() {
        double  total = 0.0;
        for (Item item : this.items) {
            total += item.price;
        }
        return total;
    }
}