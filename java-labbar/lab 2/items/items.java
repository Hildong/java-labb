package items;
import java.util.ArrayList;

import The_adventure.Player;

public class items {
    private String name;
    private double weight;
    private int price;
    private ArrayList<items> itemList = new ArrayList<items>();
    
    public items() {

    }

    public items(String name, double weight, int price) {
		this.name = name;
        this.weight = weight;
        this.price = price;
	}

    public int getPrice() {
        return this.price;
    }

    public String getItemName() {
        return this.name;
    }
    
    public double getItemWeight() {
        return this.weight;
    }

    public void addItem(items item) {
        itemList.add(item); 
    }

    public String wearItem(Player player, String itemToPutOn) {
        return "Item cannot be worn!";
    }

    public double getPerformanceBoost() {
        return 0;
    }
}
