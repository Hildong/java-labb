package location;
import java.util.concurrent.TimeUnit;

import The_adventure.Player;
import items.items;

public class Room extends Location {

    private Boolean superMuscleFluidHidden = true;
    private Boolean itemPickedUp = false;
    private items StrangeFluid = new items("Strange fluid", 0.125, 0);


    public Room(String name, String description, String paths, String placeType) {
        super(name, description, paths, placeType);
    }

    @Override
    public String lookAround(Location current, Player player) {
        if(player.getSpecificItemInInventory("Torch")) {
            return "This cave is pretty old, and the dirt here is really hard. Digging with hands would be impossible, but a shovel would be perfect";
        } else if(!player.getCurrentLocation().getLocationName().equals("Cave")) {
            return ""; 
        }
        return "The room is to dark, perhaps you need a torch or likewise.";
    }

    @Override 
    public String tryToDig(Player player) {
        if(player.getSpecificItemInInventory("Shovel") && superMuscleFluidHidden && player.getCurrentLocation().getLocationName().equals("Cave")) {
            superMuscleFluidHidden = false;
            return "While digging, you found some strange fluid in a bottle...";
        } else if(!player.getSpecificItemInInventory("Torch") && player.getCurrentLocation().getLocationName().equals("Cave")) {
            return "Room is too dark, perhaps a torch would help";
        }
        return "Area is already dugged up";
    }

    @Override
    public void pickUp(Player player, String itemToPickUp) {
        if(itemPickedUp && itemToPickUp.contains("fluid") && !superMuscleFluidHidden) {
            System.out.println("Picked up " + StrangeFluid.getItemName());
            player.addItemToInventory(StrangeFluid);
            itemPickedUp = true;
        } else {
            System.out.println("Nothing to pick up, or you were not specific enough.");
        }
    }

    @Override
    public String workout(Player player, Location currentLocation) {
        if(currentLocation.getLocationName().equals("Gym")) {
            System.out.println("Working out...");
            for(int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    System.out.println("Rep failed, workout interrupted!");
                }
                System.out.print(".");
            }
            player.setFitnessScore((int)5 * player.getFitnessBoost());
            return "Your new fitness score is " + player.getFitnessScore();
        } 
        return "If you want to workout, you should probably go to the gym" + currentLocation.getLocationName();
    }
}
 