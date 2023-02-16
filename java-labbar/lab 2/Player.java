import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Player {
	private String name = "";
	private int gold = 0;
	private int health = 0;
	private Location currentLocation;
	private Inventory Inventory;

	public Player(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public static void moveTo() {

	}

	public void doCommand(Location location) {
        location.getWalkablePaths(this.currentLocation);
    }

	// Method for creating a username
	public void getPlayerName() {
		Scanner scanPlayName = new Scanner(System.in);
		name = scanPlayName.nextLine();
		scanPlayName.close();
		System.out.println("Username is: " + name);
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
