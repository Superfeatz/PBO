// Inventory.java
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private static final int MAX_WEIGHT = 10;
    private int currentWeight;

    public Inventory() {
        items = new ArrayList<>();
        currentWeight = 0;
    }

    public boolean addItem(Item item) {
        if(currentWeight + item.getWeight() <= MAX_WEIGHT) {
            items.add(item);
            currentWeight += item.getWeight();
            return true;
        }
        return false;
    }

    public Item removeItem(String itemName) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equals(itemName)) {
                Item item = items.remove(i);
                currentWeight -= item.getWeight();
                return item;
            }
        }
        return null;
    }

    public String getItemString() {
        if(items.isEmpty()) {
            return "Inventory kosong";
        }
        String returnString = "Inventory:";
        for(Item item : items) {
            returnString += " " + item.getName();
        }
        returnString += "\nTotal berat: " + currentWeight + "/" + MAX_WEIGHT;
        return returnString;
    }
}