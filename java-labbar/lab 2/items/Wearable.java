package items;

public class Wearable extends items {
    private double damageReduction;

    public Wearable(String name, double weight, double damageReduction) {
        super(name, weight);
        this.damageReduction = damageReduction;
    }
    
    public double getDamageReduction() {
        return this.damageReduction;
    }
}
