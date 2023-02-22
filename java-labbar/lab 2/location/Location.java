package location;
import java.util.ArrayList;
import java.util.Map;

import The_adventure.Player;

public class Location {
    private String name = "";
    private String description = "";
    private String paths;
    private String placeType;
    private boolean firstTimeEntering;
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

    public Location(String name, String description, String paths, String placeType, Boolean firstTimeEntering) {
        this.name = name;
        this.description = description;
        this.paths = paths;
        this.placeType = placeType;
        this.firstTimeEntering = firstTimeEntering;
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

    public boolean getFirstTimeEnteringValue() {
        return this.firstTimeEntering;
    }

    public ArrayList getLocations() {
        return this.locationList;
    }

    public Location getSpecificLocation(int locationNum) {
        return this.locationList.get(locationNum);
    }

    public Map getDirectionToIndex() {
        return this.directionsToIndex;
    }

    public void setFirstTimeEnteringValue() {
        this.firstTimeEntering = false;
    }
    
    public void addLocation(Location loc) {
        locationList.add(loc);
    }

    public void setNewLocation(Location newLocation) {
        this.name = newLocation.name;
        this.description = newLocation.description;
        this.paths = newLocation.paths;
        this.placeType = newLocation.placeType;
        this.firstTimeEntering = newLocation.firstTimeEntering;
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
                   return getSpecificLocation(i);
                } 
            }   
        }   
        return currentLocation;
    }

}
