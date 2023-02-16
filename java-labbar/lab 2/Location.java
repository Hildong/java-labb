import java.util.ArrayList;

public class Location {
    private String name = "";
    private String description = "";
    private String paths;
    private String placeType;
    private boolean firstTimeEntering;
    private ArrayList<Location> locationList = new ArrayList<>();

    public Location() {

    }

    public Location(String name, String description, String paths, String placeType, Boolean firstTimeEntering) {
        this.name = name;
        this.description = description;
        this.paths = paths;
        this.placeType = placeType;
        this.firstTimeEntering = firstTimeEntering;
    }

    public void addLocation(Location loc) {
        locationList.add(loc);
    }

    public ArrayList getLocations() {
        return this.locationList;
    }

    public Location getSpecificLocation(int locationNum) {
        return this.locationList.get(locationNum);
    }

    public void getWalkablePaths(Location current) {
        for(int i = 0; i < locationList.size(); i++) {
            System.out.println("hello");
            System.out.println(locationList.get(i).name);
            System.out.println("hello");

            if(current.name.equals(locationList.get(i).name)) {
                System.out.println("You are in " + locationList.get(i).name);
            }
        }
    }

    public String getLocationName() {
        return this.name;
    }
}
