package location;
import java.util.ArrayList;
import java.util.Map;

import The_adventure.Player;

public class Location {
    private String name = "";
    private String description = "";
    private String paths;
    private String placeType;
    private ArrayList<Location> locationList = new ArrayList<>();
    private ArrayList<String> walkableDirections = new ArrayList<>();
    private String[] directions = {"north", "east", "south", "west"};
    private Map<String, Integer> directionsToIndex = Map.of(
        "north", 0,
        "east", 1,
        "south", 2,
        "west", 3
    );

    public Location() {

    }

    public Location(String name, String description, String paths, String placeType) {
        this.name = name;
        this.description = description;
        this.paths = paths;
        this.placeType = placeType;
    }


    public String getLocationName() {
        return this.name;
    }

    public String getLocationDescription() {
        return this.description;
    }

    public String getLocationPaths() {
        return this.paths;
    }

    public String[] getDirections() {
        return directions;
    }

    public ArrayList<Location> getLocations() {
        return this.locationList;
    }

    public Location getSpecificLocation(int locationNum) {
        return this.locationList.get(locationNum);
    }

    public Map<String, Integer> getDirectionToIndex() {
        return this.directionsToIndex;
    }

    public String getPlaceType() {
        return this.placeType;
    }

    public void setNewDescription(String locationName) {
        this.description = "You are now in " + locationName + "!";
    }
    
    public void addLocation(Location loc) {
        locationList.add(loc);
    }

    public Location setNewLocation(Location newLocation, Location currentPlayerLocation) {
        return newLocation;
    }

    public void getWalkablePaths(Location current) {
        for(int i = 0; i < 4; i++) {
            if(!current.paths.split(",")[i].equals("x")) {
                System.out.println("There is a " + (current.placeType.equals("Room") ? "door" : "path") + " leading " + directions[i]);
                walkableDirections.add(directions[i]);
            }
        }
    }

    public Location goToLocation(String currentLocationPaths, String nextLocation, int indexOfNextLocation, Location currentLocation) {
        if(walkableDirections.contains(nextLocation)) {
            for(int i = 0; i < 5; i++) {
                if(currentLocationPaths.split(",")[indexOfNextLocation].equals(getSpecificLocation(i).getLocationName())) {
                    currentLocation.setNewDescription(currentLocation.getLocationName());
                    return getSpecificLocation(i);
                } 
            }   
        }   
        return currentLocation;
    }

    public String lookAround(Location current, Player player) {
        return "";
    }

    public String returnWeather() {
        return "";
    }

    public String tryToDig(Player player) {
        return "Can't dig here.";
    }

    public void pickUp(Player player, String itemToPickUp) {
        
    }
    
    public String workout(Player player, Location currentLocation) {
        return "If you want to workout, you should probably go to the gym";
    }
}
