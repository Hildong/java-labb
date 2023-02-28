package The_adventure;

import items.items;
import items.Wearable;
import location.Location;
import location.Outside;
import location.Room;

public class Game {

    private Location loc = new Location();
    private Player player;
    private StoreOwner storeOwner = new StoreOwner();
    
    public Game() {
        addLocations();
        addStoreItems();
    }

    public void addLocations() {
        loc.addLocation(new Outside("Town", "This is the town description", "Store,Cave,Lake,Gym", "Outside"));
	    loc.addLocation(new Room("Store", "This is the Store description", "x,x,Town,x", "Room"));
	    loc.addLocation(new Room("Cave", "This is the Cave description", "x,x,Lake,Town", "Room"));
	    loc.addLocation(new Outside("Lake", "This is the Lake description", "Town,Cave,x,x", "Outside"));
	    loc.addLocation(new Room("Gym", "This is the Gym description", "x,Town,x,x", "Room"));
    }

    public void addStoreItems() {
        storeOwner.addItemToStore(new Wearable("Wrist wraps", 0.25, 100, 1.5));
        storeOwner.addItemToStore(new Wearable("Lifting belt", 2, 150, 1.75));
        storeOwner.addItemToStore(new Wearable("10KG Weight west", 10, 200, 2));
        storeOwner.addItemToStore(new Wearable("20KG Weight west", 20, 350, 2.25));
        storeOwner.addItemToStore(new items("Torch", 0.5, 100));
        storeOwner.addItemToStore(new items("Shovel", 0.5, 150));
    }
    
    public void run() {
        boolean GameOver = false;

        System.out.println("Hello Traveler. Please enter your name: ");
        this.player = new Player(new Location("Town", "This is the town description", "Store,Cave,Lake,Gym", "Town"), 10);
        player.enterPlayersName();

        System.out.println("Hello " + player.getPlayersName() + "! Welcome to Buff city Arena! You can move around by typing north/south/west/east. You can also check what is in your Inventory at any time using the command 'inv'. More commands will come to your knowledge as you play the game! (Hint: there is a command 'help')");
        System.out.println("You have finally arrived at BUFF city and you're standing in the middle of town. The reason for this adventure is to become SHREDDED! But since you are new around these areas, maybe you should have a look around to see what there is to do. ");

        while (!GameOver) {
            if(player.getCurrentLocation().getClass().getSimpleName().equals("Outside")) {
                System.out.println(player.getCurrentLocation().returnWeather());
            } 
            loc.getWalkablePaths(player.getCurrentLocation());
            System.out.println("\nWhat do you want to do?");
            System.out.println(player.doCommand(loc, storeOwner, player.getCurrentLocation()));;
        }
        
    }
}
