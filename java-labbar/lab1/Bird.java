public class Bird extends Animal {

    Bird(String name, int age) {
	    super(name, age);   
	}

	void introduceYourself() {
		System.out.println("\nPip Pip! Jag är en fågel vid namn " + this.getName() + ".");
		System.out.println("Jag är " + this.getAge() + " år gammal.");
	}
	
	String makeSound() {
		return "Pip pip!";
	}
	  
	void fly() {
		System.out.println("Flax flax, jag flaxar med vingarna!");
	}
}
