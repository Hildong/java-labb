package The_adventure;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import items.Blobfish;
import items.Cod;
import items.Salmon;
import items.Trout;
import location.Location;
import items.items;

public class Player {
	private String name = "";
	private int gold = 0;
	private int fitnessScore;
	public int fitnessBoost = 1;
	private Location currentLocation;
	private Scanner inputScanner = new Scanner(System.in);
	private ArrayList<items> inventory = new ArrayList<items>();
	private items itemClass= new items();

	public Player(Location currentLocation, int fitnessScore) {
		this.currentLocation = currentLocation;
		this.fitnessScore = fitnessScore;
	}

	// Method for creating a username
	public void enterPlayersName() {
		name = inputScanner.nextLine();
	}

	public String getPlayersName() {
		return name;
	}

	public Location getCurrentLocation() {
		return this.currentLocation;
	}

	public void getInventoryItems() {
		if(inventory.isEmpty()) {
			System.out.println("Inventory is empty");
		} else {
			System.out.println("\nIn your inventory you have:\n");
			for (items item : inventory)
			{ 		      
				System.out.println("" + item.getItemName() + " (" + String.format("%.2f", item.getItemWeight()) + "kg)");		
			}
		}
	}

	public ArrayList<items> getFullInventory() {
		return inventory;
	}

	public Boolean getSpecificItemInInventory(String itemToSearchFor) {
		for (items item : inventory)
		{ 		      
			if(item.getItemName().equals(itemToSearchFor)) {
				return true;
			}	
		}

		return false;
	}

	public items returnSpecificItemInInvetory(String itemToSearchFor) {
		for (items item : inventory)
		{ 		      
			if(item.getItemName().equals(itemToSearchFor)) {
				return item;
			}	
		}
		return null;
	}

	public int getGold() {
		return this.gold;
	}

	public int getFitnessScore() {
		return this.fitnessScore;
	} 

	public int getFitnessBoost() {
		return this.fitnessBoost;
	}

	public void setFitnessScore(int addedFitnessScore) {
		this.fitnessScore += addedFitnessScore;
	}

	public void setFitnessBoost(double boost) {
		this.fitnessBoost += boost;
	}

	public void setGold(int cost) {
		this.gold = cost;
	}

	public void addItemToInventory(items newItem) {
		this.inventory.add(newItem);
	}

	public void removeFromInventory(items item) {
		this.inventory.remove(item);
	}

	public void setCurrentLocation(Location newLocation) {
		this.currentLocation = newLocation;
	}

	public String doCommand(Location location, StoreOwner storeOwner, Location currentLocation) {
		String playerOption = inputScanner.nextLine();

		switch(playerOption) {
			case "help":
				return "\nQuest - Fish at the lake, sell gold in Town store, buy training equipment and suppliments at store or find in Cave. \n Commands: \n 'help', 'north/east/south/west', 'fish' (in lake), 'buy/sell' (in store), 'wear', 'take', 'dig', 'items', 'gold', 'workout' (in gym)\n";
			case "fish":
				return this.Fishing();
			case "items":
				this.getInventoryItems();
				return "";
			case "look":
				return currentLocation.lookAround(currentLocation, this);
			case "buy":
				return storeOwner.Buy(this, storeOwner.returnShopListItems());
			case "sell":
				return storeOwner.Sell(this); 
			case "gold":
				return "You have " + this.gold + " gold.";
			case "dig":
				return currentLocation.tryToDig(this);
			case "workout":
				return currentLocation.workout(this, currentLocation);
			default:

				for(String direction : location.getDirections()) {
					if(playerOption.equals(direction)) {
						this.currentLocation = location.setNewLocation(location.goToLocation(this.currentLocation.getLocationPaths(), playerOption, (int)location.getDirectionToIndex().get(playerOption), currentLocation), this.currentLocation);
						if(this.currentLocation.getLocationName().equals("Cave")) {
							this.currentLocation.lookAround(currentLocation, this);
						} else if(this.currentLocation.getLocationName().equals("Store")) {
							storeOwner.greeting();
						}
						return this.currentLocation.getLocationDescription();
					}
				}

				if(playerOption.contains("wear")) {
					try {
						return itemClass.wearItem(this, playerOption.split(" ")[1]);
					} catch (Exception e) {
						return "Please also provide an item to wear (wear x)";
					}
				}

				if(playerOption.contains("take")) {
					try {
						currentLocation.pickUp(this, playerOption.split(" ")[1]);
						return "";
					} catch (Exception e) {
						return "Please also provide an item to take (take x)";
					}
				}
				return "\nNot a valid command, try again or type 'help' to get existing commands";
		}
		
	}

	public String Fishing() {	

		if(this.currentLocation.getLocationName().equals("Lake")) {
			Random rand = new Random();
			int randomNum = rand.nextInt((1000 - 0) + 1) + 1;
			double weightOfFish = rand.nextDouble((5 - 1) + 1) + 1;
			if(randomNum >= 151 && randomNum <= 250) {
				inventory.add(new Blobfish("Blobfish", weightOfFish));
				return "You caught a blobfish!";
			} else if (randomNum >=251 && randomNum <=550) {
				inventory.add(new Trout("Trout", weightOfFish));
				return "You caught a trout!";
			}
			else if (randomNum >=551 && randomNum <=800) {
				inventory.add(new Cod("Cod", weightOfFish));
				return "You caught a cod!";
			}
			else  {
				inventory.add(new Salmon("Salmon", weightOfFish));
				return "You caught a salmon!";
			}
		}
		return "Nothing on the hook...";
	}
}
