package location;
import java.util.Map;
import java.util.Random;

public class Outside extends Location {

    private Map<String, Integer> weatherCondition = Map.of(
        "Sunny", 1,
        "Windy", 1,
        "Snowy", 0,
    );


    public Outside(String name, String description, String paths, String placeType) {
        super(name, description, paths, placeType);
    }

    public Map returnWeather() {
        Random rand = new Random();
        int n = rand.nextInt(3);

        if(n =< 1) {
            return weatherCondition;
        }
    }
   
}
