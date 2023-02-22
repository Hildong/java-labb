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
	private int health = 0;
	private Location currentLocation;
	private Scanner inputScanner = new Scanner(System.in);
	private ArrayList<items> inventory = new ArrayList<>();

	public Player(Location currentLocation) {
		this.currentLocation = currentLocation;
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

	public void getInventory() {
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

	public Boolean getSpecificItemInInventory(String itemToSearchFor) {
		for (items item : inventory)
		{ 		      
			if(item.getItemName().equals(itemToSearchFor)) {
				return true;
			}	
		}

		return false;
	}

	public void setCurrentLocation(Location newLocation) {
		this.currentLocation = newLocation;
	}

	public String doCommand(Location location, Location currentLocation) {
		String playerOption = inputScanner.nextLine();
		
		switch(playerOption) {
			case "help":
				return "\nQuest - Fish at the lake, sell gold in Town store, buy weapons and armor at store or find in Cave. \n Commands: \n 'help', 'north/east/south/west', 'enter/leave (in cave)', 'fish (in lake)', 'wear', 'take', 'inv'\n";
			case "fish":
				return this.Fishing();
			case "inv":
				this.getInventory();
				return "";
			case "look":
				return "";//currentLocation.lookAround(currentLocation, this);
			default:
				for(String direction : location.getDirections()) {
					if(playerOption.equals(direction)) {
						this.currentLocation.setNewLocation(location.goToLocation(this.currentLocation.getLocationPaths(), playerOption, (int)location.getDirectionToIndex().get(playerOption), currentLocation));
						if(this.currentLocation.getFirstTimeEnteringValue()) {
							this.currentLocation.setFirstTimeEnteringValue();
							return this.currentLocation.getLocationDescription();
						} 
						return "\nYou are at the " + this.currentLocation.getLocationName();
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
