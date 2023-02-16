public class Cat extends Animal {

    Cat(String name, int age) {
	    super(name, age);   
	}

	void introduceYourself() {
		System.out.println("\nMjau. Jag är en katt som heter " + this.getName() + ".");
		System.out.println("Jag är " + this.getAge() + " år gammal.");
	}
	
	String makeSound() {
		return "Purrrrrr";
	}
	  
	void fly() {
		System.out.println("Jag kan inte flyga!");
	}
}
