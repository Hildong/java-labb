package items;
import java.util.ArrayList;

import The_adventure.Player;

public class Wearable extends items {

    private double performanceBoost;
    private ArrayList<String> equippedItems = new ArrayList<>();

    public Wearable(String name, double weight, int price, double performanceBoost) {
        super(name, weight, price);
        this.performanceBoost = performanceBoost;
    }
    
    @Override
    public double getPerformanceBoost() {
        return this.performanceBoost;
    }
    
    @Override
    public String wearItem(Player player, String itemToPutOn) {
        if(equippedItems.contains(itemToPutOn)) {
            return "Already wearing " + itemToPutOn;
        } else if(!player.getSpecificItemInInventory(itemToPutOn)) {
            return "No such item in inventory";
        }
        player.setFitnessBoost(player.returnSpecificItemInInvetory(itemToPutOn).getPerformanceBoost());
        return "Put on " + itemToPutOn + ". Now you have " + player.getFitnessBoost() + "x fitness boost.";
    }
}
