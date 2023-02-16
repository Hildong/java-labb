import java.util.Random;

public class Trout extends Fish {
	public Trout(String name, int value, double weight) {
		super(name, value, weight);
		Random rand = new Random();
		int randomNum = rand.nextInt((30 - 1) + 1) + 1;
		name = "Trout";
		value = 5;
		weight = randomNum;
		
	}
}
