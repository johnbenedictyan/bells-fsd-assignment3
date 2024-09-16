import java.util.Scanner;

/**
 * Item
 */
public class Item implements Editable<Item> {
    public String name;
    public double price;
    public int stock;
    public String rarity;

    public Item() {
        this.name = "Unknown Item";
        this.price = 0.0;
        this.stock = 0;
        this.rarity = "normal";
    }

    public Item(String name, double price, int stock, String rarity) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.rarity = rarity;
    }

    @Override
    public void handleEdit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new name for the item");
        String newName = sc.nextLine();
        this.name = newName;

        System.out.println("Enter the new price for the item");
        double newPrice = sc.nextDouble();
        sc.nextLine(); // consume the buffered new line
        this.price = newPrice;

        System.out.println("Enter the new stock for the item");
        int newStock = sc.nextInt();
        sc.nextLine(); // consume the buffered new line
        this.stock = newStock;

    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %.2f, Quantity: %d", this.name, this.price, this.stock);
    }

}