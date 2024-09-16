import java.util.Scanner;

/**
 * MagicItem
 */
public class MagicItem extends Item {
    public String element;

    public MagicItem() {
        super();
        this.element = "Unknown Element";
    }

    public MagicItem(String name, double price, int stock, String rarity, String element) {
        super(name, price, stock, rarity);
        this.element = element;
    }

    @Override
    public void handleEdit() {
        super.handleEdit();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new element");
        String element = sc.nextLine();
        this.element = element;


    }

}