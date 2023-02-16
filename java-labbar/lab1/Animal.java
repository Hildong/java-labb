import java.util.ArrayList; 

public class Animal {
    private static int currentYear;
    private String name;
    private int birthyear;
    private Animal friend;
    ArrayList<Toy> toyList = new ArrayList<Toy>();
    
    public Animal(String name, int age) {
        this.name = name;
        this.birthyear = Animal.currentYear - age;
    }

    public static void setYear(int year) {
      Animal.currentYear = year;
    }
    
    public String getName() {
        return this.name;
    }

    public int getAge() {
      return Animal.currentYear - this.birthyear;
    }
  
    public void setFriend(Animal animalsFriend) {
      friend = animalsFriend;
    }

    public void addToy(Toy toy) {
      toyList.add(toy);
    }
    
    public void print() {

    System.out.println("\nHej. Jag bor i detta hus och heter " + this.name + ".");
    if(!toyList.isEmpty()) {
      System.out.println("Mina leksaker är: ");
      for (Toy toy : toyList) {
        System.out.println(toy.toyName);
      }
    } 

     if (friend != null) {
         System.out.println("Här är uppgifter om min kompis:\n");
         friend.introduceYourself();
      } else {
          System.out.println("Jag har ingen kompis.");
      }

  }

    void introduceYourself() {
      // ???
    }
  
    String makeSound() {
      return ""; // ???
    }
    
    void fly() {
      // ???
    }
  
}