import java.util.*;

public class App {
    static final int BREAK_NUMBER = 0;

    public static void main(String[] args) throws Exception {
        ArrayList<Item> Inventory = new ArrayList<>();
        Inventory.add(new Item("Dagger", 0.5, 3, "Normal"));
        Inventory.add(new Item("Plate Mail", 10.0, 3, "Rare"));
        Inventory.add(new Item("Chain Mail", 2.0, 3, "Normal"));
        Inventory.add(new Item("Long Sword", 1.0, 3, "Normal"));

        HashMap<Integer, String> choices = new HashMap<>();
        choices.put(BREAK_NUMBER, "Leave. (Exit Inventory)");
        choices.put(1, "Browse Inventory");
        choices.put(2, "Add Item to Inventory");
        choices.put(3, "Update Item in Inventory");

        while (true) {
            displayMenu(choices);
            int choice = getMenuChoice(choices);
            boolean keepRunning = processChoice(choice, Inventory);
            if (keepRunning == false) {
                break;
            }
        }
    }

    public static void displayMenu(HashMap<Integer, String> choices) {
        System.out.println("I am the magic backpack");
        choices
                .entrySet()
                .stream()
                .map(x -> String.format("Choice [%s]: %s", x.getKey(), x.getValue()))
                .forEach(System.out::println);
    }

    public static int getMenuChoice(HashMap<Integer, String> choices) {
        Scanner sc = new Scanner(System.in);
        int action = -1;
        while (true) {
            System.out.print("Enter choice: ");
            action = sc.nextInt();
            sc.nextLine(); // consume the buffered new line
            if (!choices.containsKey(action)) {
                System.out.println("Invalid Choice! Please choose again...");
            } else {
                break;
            }
        }


        return action;
    }

    public static boolean processChoice(int choice, ArrayList<Item> inventory) {
        Scanner sc = new Scanner(System.in);

        switch (choice) {
            case BREAK_NUMBER:
                System.out.println("Thank you for coming. See you again!");

                return false;

            case 1:
                System.out.println("____Inventory____");
                for (int i = 0; i < inventory.size(); i++) {
                    System.out.println(inventory.get(i));
                }
                System.out.println("_______________");


                return true;
            case 2:
                System.out.println("Add new item");
                System.out.println("Enter the type of item to create");
                System.out.println("M for magic or N for normal");

                String itemType = sc.nextLine();
                while (!itemType.toUpperCase().equals("M") && !itemType.toUpperCase().equals("N")) {
                    System.out.println("Enter the type of item to create");
                    System.out.println("M for magic or N for normal");
                    itemType = sc.nextLine();

                }

                // ask the user to enter details for parent item class
                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter price: ");
                double price = sc.nextDouble();
                sc.nextLine(); // get rid of the buffered \n

                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();
                sc.nextLine(); // get rid of the buffered \n

                System.out.print("Enter Rarity: ");
                String rarity = sc.nextLine();

                // create a placeholder and set it to empty
                Item newItem = new Item(name, price, qty, rarity);

                if (itemType.toUpperCase().equals("M")) {
                    // ask the user for information pertaining to the digital item
                    System.out.print("Enter the element: ");
                    String element = sc.nextLine();

                    // the `newItem` is the placeholder that we have created before the `if`
                    newItem = new MagicItem(name, price, qty, rarity, element);
                }
                inventory.add(newItem);

                return true;

            case 3:
                System.out.print("Enter index to edit: ");
                int itemIdx = sc.nextInt();

                // 2. base on the item, we will ask the questions for
                // the new values for the item
                Item itemToEdit = inventory.get(itemIdx);
                itemToEdit.handleEdit();

                return true;

            default:

                return false;
        }
    }
}
