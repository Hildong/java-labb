package location;
import java.util.Random;

public class Outside extends Location {

    public Outside(String name, String description, String paths, String placeType, boolean firstTime) {
        super(name, description, paths, placeType, firstTime);
    }

    public String returnWeather() {
        Random rand = new Random();
        int n = rand.nextInt(10);

        if(n <= 1) {
            return "Snowy";
        } else if(n > 2 && n < 6) {
            return "Windy";
        } else {
            return "Sunny";
        }
    }
   
}
