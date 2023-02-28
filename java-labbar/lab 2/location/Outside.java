package location;
import java.util.Random;

public class Outside extends Location {

    private String currentWeather = "The sun is out. Nice!";

    public Outside(String name, String description, String paths, String placeType) {
        super(name, description, paths, placeType);
    }

    @Override
    public String returnWeather() {
        Random rand = new Random();
        int changeWeather = rand.nextInt(10);
        int weatherProcentChance = rand.nextInt(10);

        if(changeWeather < 3) {
            if(weatherProcentChance <= 1) {
                currentWeather = "Brrrr!!! It seems to be snowing outside.";
            } else if(weatherProcentChance > 2 && weatherProcentChance < 6) {
                currentWeather = "Ouf! It's really windy outside.";
            } else {
                currentWeather = "The sun is out. Nice!";
            }
        }
        return currentWeather;
    }
   
}
