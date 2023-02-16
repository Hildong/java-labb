public class Butterfly extends Animal {
    Butterfly(String name, int age) {
	    super(name, age);   
	}

	void introduceYourself() {
		System.out.println("\nHej, jag är fjärilen " + this.getName() + ".");
		System.out.println("Jag är " + this.getAge() + " år gammal.");
	}
	
	String makeSound() {
		return ""; // ???
	}
	  
	void fly() {
		System.out.println("Flax flax, jag flaxar med vingarna!");
	}
}
