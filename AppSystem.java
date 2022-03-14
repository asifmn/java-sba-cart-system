


import java.util.HashMap;
import java.util.Map;

public class AppSystem extends TheSystem {
    AppSystem() {
    }

    @Override
    public void display() {
        int longestNameL = 0;
        int longestDescL = 0;
        int longest = 0;
        for (Map.Entry<String, Item> it : this.getItemCollection().entrySet()) {
            int nameLength = it.getValue().getItemName().length();
            int descLength = it.getValue().getItemDesc().length();
            longestNameL = nameLength > longestNameL ? nameLength : longestNameL;
            longestDescL = descLength > longestDescL ? descLength : longestDescL;
            longest = longestNameL > longestDescL ? longestNameL : longestDescL;
        }
        longest = longest > 12 ? longest : 12;
        Utilities.separate(" ", (longest + 3) * 5);
        System.out.println(Utilities.wallIn(Utilities.rightPadder("Name", longest)).replace('|', ' ')
                + Utilities.wallIn(Utilities.rightPadder("Description", longest)).replace('|', ' ')
                + Utilities.wallIn(Utilities.rightPadder("Price", longest)).replace('|', ' ')
                + Utilities.wallIn(Utilities.rightPadder("Available Quantity", longest)).replace('|', ' '));
        Utilities.separate(" ", (longest + 3) * 5);
        for (Map.Entry<String, Item> it : this.getItemCollection().entrySet()) {
            String itemName = it.getValue().getItemName();
            String itemDesc = it.getValue().getItemDesc();
            int availQuant = it.getValue().getAvailableQuantity();
            double itemPrice = it.getValue().getItemPrice();

            System.out.println(Utilities.wallIn(Utilities.rightPadder(itemName, longest)).replace('|', ' ')
                    + Utilities.wallIn(Utilities.rightPadder(itemDesc, longest)).replace('|', ' ')
                    + Utilities.wallIn(Utilities.rightPadder(String.valueOf(itemPrice), longest)).replace('|', ' ')
                    + Utilities.wallIn(Utilities.rightPadder(String.valueOf(availQuant), longest)).replace('|', ' '));
            Utilities.separate(" ", (longest + 3) * 5);

        }
    }

    @Override
    public Boolean add(Item item) {
        if (item == null) {
            return false;
        } else if (this.getItemCollection().containsKey(item.getItemName())) {

            System.out.println(item.getItemName() + " is already in the App System");
            return false;
        } else {
            this.getItemCollection().put(item.getItemName(), item);

            return true;
        }
    }

    public Item reduceAvailableQuantity(String item_name) {

        Item item=null;
        for (Map.Entry<String, Item> it : this.getItemCollection().entrySet()) {
            if(it.getValue().getItemName().equals(item_name))
            {
          int av=  it.getValue().getAvailableQuantity();
          av--;
          it.getValue().setAvailableQuantity(av);
                HashMap<String,Item> map= this.getItemCollection();
                map.put(it.getKey(),it.getValue());
                this.setItemCollection(map);
                item=it.getValue();
                break;
            }
        }
return item;
        }
}
