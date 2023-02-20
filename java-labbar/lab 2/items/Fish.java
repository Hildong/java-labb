package items;

public class Fish {
	String name;
	int value;
	double weight;
	public Fish(String name, int value, double weight) {
		
	}
	//MOVE TO CLERK CLASS WHEN THAT CLASS IS MADE
	public void calculateValue() {
		value *= weight/10;
	}
	//MOVE TO CLERK CLASS WHEN THAT CLASS IS MADE

}
