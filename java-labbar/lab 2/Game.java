import java.util.*;

public class Game {

    private Scanner keyboard; 
    private Location loc = new Location();
    private Player player;
    
    public Game() {
	    keyboard = new Scanner(System.in);
        loc.addLocation(new Location("Town", "This is the town description", "Store,Cave,Lake,Arena", "Town", true));
	    loc.addLocation(new Location("Store", "This is the Store description", "x,x,Town,x", "Store", true));
	    loc.addLocation(new Location("Cave", "This is the Cave description", "x,x,Lake,Town", "Cave", true));
	    loc.addLocation(new Location("Lake", "This is the Lake description", "Town,Cave,x,x", "Lake", true));
	    loc.addLocation(new Location("Arena", "This is the Arena description", "x,Town,x,x", "Arena", true));
    }

    public void run() {
        boolean GameOver = false;

        System.out.println("Hello Traveler. Please enter your name: ");
        this.player = new Player(loc.getSpecificLocation(0));
        player.getPlayerName();
        loc.getLocations();


        player.Fish();
    }
}
