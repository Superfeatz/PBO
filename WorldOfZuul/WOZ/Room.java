// Room.java
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

public class Room {
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getDescription() {
        return description;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getExitString() {
        String returnString = "";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(String itemName) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equals(itemName)) {
                return items.remove(i);
            }
        }
        return null;
    }

    public String getLongDescription() {
        String returnString = "Kamu " + description + ".\n";
        returnString += "Exits:" + getExitString() + "\n";
        returnString += "Items:" + getItemString();
        return returnString;
    }

    public String getItemString() {
        if(items.isEmpty()) {
            return " tidak ada item di ruangan ini";
        }
        String returnString = "";
        for(Item item : items) {
            returnString += " " + item.getName();
        }
        return returnString;
    }
}
