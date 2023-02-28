package The_adventure;
import java.util.ArrayList;
import java.util.Scanner;

import items.items;

public class StoreOwner {
    private ArrayList<items> shopListItems = new ArrayList<>();
    private int loops = 0; 
	private Scanner inputScanner = new Scanner(System.in);
    private items itemToRemoveOrAdd;

    public StoreOwner() {

    }

    public ArrayList<items> returnShopListItems() {
        return shopListItems;
    }

    public void greeting() {
        System.out.println("Hello traveler! What can I do for you today? (buy/ sell)");
    }

    public void addItemToStore(items storeItem) {
        shopListItems.add(storeItem);
    }

    public void printOutItems(ArrayList<items> inventory, Boolean isBuying) {
        loops = 0;
        for(items inventoryItems : inventory) {
            System.out.print(inventory.indexOf(inventoryItems) + ".");
            if(isBuying) {
                System.out.print("(" + inventoryItems.getPrice() + " gold)");
            }
            System.out.println(inventoryItems.getItemName() + " (" + String.format("%.2f", inventoryItems.getItemWeight()) + "kg)");
        }
        System.out.println("Type the number to match action, or a number above " + (inventory.size() -1) + " to exit");
		
    }

    public String Sell(Player player) {
        if(player.getFullInventory().isEmpty()) {
            return "Inventory empty";
        }
        printOutItems(player.getFullInventory(), false);
        String playerOption = inputScanner.nextLine();

        for(items inventoryItems : player.getFullInventory()) {
            loops++;
            if(Integer.parseInt(playerOption) == player.getFullInventory().indexOf(inventoryItems)) {
                if(!inventoryItems.getClass().getSimpleName().equals("Wearable") && !inventoryItems.getClass().getSimpleName().equals("Supplement")) {
                    player.setGold(player.getGold() + ((int)(inventoryItems.getPrice() * 0.9)));
                } else {
                    player.setGold(player.getGold() + ((int)(inventoryItems.getPrice() * inventoryItems.getItemWeight())));
                }
                itemToRemoveOrAdd = inventoryItems;
            }
        }
        if(Integer.parseInt(playerOption) > loops+1) {
            System.out.println("Cancelled sell offer");
        } else {
            player.removeFromInventory(itemToRemoveOrAdd);
            return "You sold " + itemToRemoveOrAdd.getItemName();
        }

        return "Nothing sold! You have " + player.getGold() + " gold.";
    }
 
    public String Buy(Player player, ArrayList<items> itemsAtStore) {
        printOutItems(itemsAtStore, true);
        String playerOption = inputScanner.nextLine();

        for(items inventoryItems : itemsAtStore) {
            loops++;
            if(Integer.parseInt(playerOption) == shopListItems.indexOf(inventoryItems) && player.getGold() >= inventoryItems.getPrice()) {
                player.setGold(player.getGold() - (inventoryItems.getPrice()));
                itemToRemoveOrAdd = inventoryItems;
            } else if(Integer.parseInt(playerOption) == shopListItems.indexOf(inventoryItems) && inventoryItems.getPrice() > player.getGold()) {
                return "You have " + player.getGold() + ", and this item costs" + inventoryItems.getPrice() + inventoryItems.getItemName();
            }
        }
        if(Integer.parseInt(playerOption) > loops+1) {
            System.out.println("Cancelled purchase");
        } else {
            player.addItemToInventory(itemToRemoveOrAdd);
            return "You purchased " + itemToRemoveOrAdd.getItemName();
        }
        return "Nothing purchased! You have " + player.getGold() + " gold.";
    }

}
