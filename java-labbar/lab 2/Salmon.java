import java.util.Random;

public class Salmon extends Fish {
public Salmon(String name, int value, double weight) {
	super(name, value, weight);
	Random rand = new Random();
	int randomNum = rand.nextInt((30 - 1) + 1) + 1;
	name = "Salmon";
	value = 40;
	weight = randomNum;
}
}
