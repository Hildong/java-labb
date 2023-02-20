import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Player {
	private String name = "";
	private int gold = 0;
	private int health = 0;
	private Location currentLocation;

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
	public void Fishing(Inventory inventory) {	
		System.out.println("hej");
		//if(Inventory.equipmentList = "Fishing Rod") {
		Random rand = new Random();
		int randomNum = rand.nextInt((1000 - 0) + 1) + 1;
		if (randomNum == 0) {
			Fish Blobfish = new Blobfish("Blobfish", 0, 0);
			inventory.addFish(Blobfish);
			System.out.println("W");
		} else if (randomNum >=1 && randomNum <=500) {
			Fish Trout = new Trout("Trout", 0, 0);
			inventory.addFish(Trout);
			System.out.println("L");
		}
		else if (randomNum >=501 && randomNum <=800) {
			Fish Cod = new Cod("Cod", 0, 0);
			inventory.addFish(Cod);
			System.out.println("G");
		}
		else if (randomNum >=801 && randomNum <=1000) {
			Fish Salmon = new Salmon("Salmon", 0, 0);
			inventory.addFish(Salmon);
			System.out.println("C");
		}
		else {
			System.out.println("Hejsss");
		}

	}
		

}
