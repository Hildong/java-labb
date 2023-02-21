package The_adventure;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

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
	private Scanner inputScanner = new Scanner(System.in);

	public Player(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String doCommand(Location location, Location currentLocation) {
		String playerOption = inputScanner.nextLine();
		//System.out.println(location.getSpecificLocation(0));
		
		if(playerOption.equals("help")) {
			return "\nQuest - Fish at the lake, sell gold in Town store, buy weapons and armor at store or find in Cave. \n Commands: \n 'help', 'north/east/south/west', 'enter/leave (in cave)', 'wear', 'take'\n";
		} else {
			for(String direction : location.getDirections()) {
				if(playerOption.equals(direction)) {
					this.currentLocation.setNewLocation(location.goToLocation(this.currentLocation.getLocationPaths(), playerOption, (int)location.getDirectionToIndex().get(playerOption), currentLocation));
					return "\n" + this.currentLocation.getLocationDescription();
				}
			}
		}

		return "\nNot a valid command, try again or type 'help' to get existing commands";
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

}
