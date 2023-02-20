package items;

public class Weapon extends items {
    private int damage;

    public Weapon(String name, double weight, int damage) {
        super(name, weight);
        this.damage = damage;
    }
    
    public int getDamage() {
        return this.damage;
    }
    
}
