package location;

import The_adventure.Player;

public class Room extends Location {
    public Room(String name, String description, String paths, String placeType, boolean firstTime) {
        super(name, description, paths, placeType, firstTime);
    }

    public String lookAround(Location current, Player player) {
        return "The room is to dark, perhaps you need a torch or likewise.";

    }
}
 