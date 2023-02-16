public class Dog extends Animal {

	Dog(String name, int age) {
	    super(name, age);   
	}

	void introduceYourself() {
		System.out.println("\nVovv!!! Jag är en hund som kallas " + this.getName() + ".");
		System.out.println("Jag är " + this.getAge() + " år gammal.");
	}
	
	String makeSound() {
		return "Vov, vov, vovv!!!";
	}
	  
	void fly() {
		System.out.println("Jag kan inte flyga!");
	}

}
