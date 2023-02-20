package The_adventure;
import java.util.*;

import location.Location;

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
        this.player = new Player(new Location("Town", "This is the town description", "Store,Cave,Lake,Arena", "Town", true));
        player.enterPlayersName();

        System.out.println("Hello " + player.getPlayersName() + "! Welcome to Buff city Arena! You can move around by typing north/south/west/east. You will have to learn more commands as you play the game! (Hint: there is a command 'help')");
        System.out.println("You have finally arrived at BUFF city and you're standing in the middle of town, to become the champion of BUFF citys Arena battle! But since you are new around these areas, maybe you should have a look around to see what there is to do. ");

        while (!GameOver) {
            loc.getWalkablePaths(player.getCurrentLocation());
            player.doCommand(loc, player.getCurrentLocation());
        }
        
        player.Fish();
    }
}
