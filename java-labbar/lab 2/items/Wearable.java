public class Wearable {
    private double damageReduction;

    public Weapon(String name, double weight, double damageReduction) {
        super(name, weight);
        this.damageReduction = damageReduction;
    }
    
    public getDamageReduction() {
        return this.damageReduction;
    }
}
