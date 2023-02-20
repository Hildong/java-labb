package The_adventure;
import java.util.ArrayList;

import items.Fish;

public class Inventory {
	// Lists for different item types
	ArrayList<Fish> fishList = new ArrayList<>();
	ArrayList<Equipment> equipmentList = new ArrayList<>();

//	ArrayList<Wearables> wearList = new ArrayList<>();
	public Inventory() {

	}

	// Add methods for different item types
	public void addFish(Fish fish) {
		fishList.add(fish);
	}

//	public void addWear(Wearables wear) {
//		wearList.add(wear);
//	}
}

//Method for printing contents in inventory
	public void printInv() {
		System.out.println(fishList);
	}
}