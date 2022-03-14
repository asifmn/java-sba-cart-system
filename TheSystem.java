

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {

    private HashMap<String, Item> itemCollection;

    public HashMap<String, Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(HashMap<String, Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    TheSystem() {
        itemCollection = new HashMap<String, Item>();
        if (getClass().getSimpleName().equals("AppSystem")) {
            try {
                FileReader file = new FileReader(new File("src\\sample.txt"));
                Scanner filescan = new Scanner(file);
                while (filescan.hasNextLine()) {
                    String[] itemInfo = filescan.nextLine().split("  ");
                    Item it = new Item();
                    it.setItemName(itemInfo[0]);
                    it.setItemDesc(itemInfo[1]);
                    it.setItemPrice(Double.valueOf(itemInfo[2]));
                    it.setAvailableQuantity(Integer.valueOf(itemInfo[3]));
                    itemCollection.put(it.getItemName(), it);
                }
                filescan.close();

            } catch (FileNotFoundException ex) {
                System.err.println("Something went wrong and could not load item list file.");
                ex.printStackTrace();

            }

        }
    }

    public Boolean checkAvailability(Item item) {
        if (item.getAvailableQuantity() < item.getQuantity()) {
            String unavailable = "System is unable to add " + item.getItemName() + " to the card. System only has "
                    + item.getAvailableQuantity() + " " + item.getItemName() + "s.";
            System.err.println(unavailable);
            return false;
        } else {
            return true;
        }
    }

    public Boolean add(Item item) {
        if (item == null) {
            return false;
        } else if (this.itemCollection.containsKey(item.getItemName())) {
            Item collItem = this.itemCollection.get(item.getItemName());
            int currentQuant = collItem.getQuantity();
            collItem.setQuantity(currentQuant + 1);
            this.itemCollection.put(item.getItemName(), collItem); // Put replaces a value if it already contains it.
            return true;
        } else {
            this.itemCollection.put(item.getItemName(), item);
            return true;
        }
    }

    public Item remove(String itemName) {
        return this.itemCollection.remove(itemName);
    }

    public abstract void display();
}
