package The_adventure;
import java.util.ArrayList;
import java.util.Scanner;

import items.Blobfish;
import items.Cod;
import items.Fish;
import items.Salmon;
import items.Trout;
import location.Location;

import java.util.Random;

public class Player {
	private String name = "";
	private int gold = 0;
	private int health = 0;
	private Location currentLocation;
	private Inventory Inventory;
	private Scanner inputScanner = new Scanner(System.in);

	public Player(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public void doCommand(Location location, Location currentLocation) {
		String playerOption = inputScanner.nextLine();
		//System.out.println(location.getSpecificLocation(0));
		
		this.currentLocation.setNewLocation(location.goToLocation(this.currentLocation.getLocationPaths(), playerOption, (int)location.getDirectionToIndex().get(playerOption), currentLocation));
		System.out.println("\n" + this.currentLocation.getLocationDescription());

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

	public void setCurrentLocation(Location newLocation) {
		this.currentLocation = newLocation;
	}

	// Random fish generator for fishing feature
	public void Fish() {	
		//if(Inventory.equipmentList = "Fishing Rod") {
		Random rand = new Random();
		int randomNum = rand.nextInt((1000 - 0) + 1) + 1;
		if (randomNum == 0) {
			Fish Blobfish = new Blobfish("Blobfish", 0, 0);
			Inventory.addFish(Blobfish);
		} else if (randomNum == 1-500) {
			Fish Trout = new Trout("Trout", 0, 0);
			Inventory.addFish(Trout);
		}
		else if (randomNum == 501-800) {
			Fish Cod = new Cod("Cod", 0, 0);
			Inventory.addFish(Cod);
		}
		else if (randomNum == 801-1000) {
			Fish Salmon = new Salmon("Salmon", 0, 0);
			Inventory.addFish(Salmon);
		}

	}

}
