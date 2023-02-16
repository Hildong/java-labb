import java.util.Random;

public class Cod extends Fish {
	public Cod(String name, int value, double weight) {
		super(name, value, weight);
		Random rand = new Random();
		int randomNum = rand.nextInt((12 - 1) + 1) + 1;
		name = "Cod";
		value = 10;
		weight = randomNum; 
	}
}
