
package The_adventure;
import java.util.ArrayList;
import java.util.Scanner;

import items.Blobfish;
import items.Cod;
import items.Salmon;
import items.Trout;
import location.Location;
import items.items;

import java.util.Random;

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
	public void Fishing() {	
		System.out.println("hej");
		//if(Inventory.equipmentList = "Fishing Rod") {
		Random rand = new Random();
		int randomNum = rand.nextInt((1000 - 0) + 1) + 1;
		if (randomNum == 0) {
			inventory.add(new Blobfish("Blobfish", 0, 0));
			System.out.println("W");
		} else if (randomNum >=1 && randomNum <=500) {
			inventory.add(new Trout("Trout", 0, 0));
			System.out.println("L");
		}
		else if (randomNum >=501 && randomNum <=800) {
			inventory.add(new Cod("Cod", 0, 0));
			System.out.println("G");
		}
		else if (randomNum >=801 && randomNum <=1000) {
			inventory.add(new Salmon("Salmon", 0, 0));
			System.out.println("C");
		}
		else {
			System.out.println("Hejsss");
		}
	}

}
