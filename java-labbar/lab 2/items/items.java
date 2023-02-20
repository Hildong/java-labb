package items;
import java.util.ArrayList;

public class items {
    private String name;
    private double weight;
    private ArrayList<Item> items = new ArrayList<Item>();
    
    public Item() {

    }

    public Item(String name, double weight) {
		this.name = name;
        this.weight = weight;
	}

    public void addItem(items item) {
        items.add(item); 
    }
    
    
}
