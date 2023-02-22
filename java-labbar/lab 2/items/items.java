package items;
import java.util.ArrayList;

public class items {
    private String name;
    private double weight;
    private ArrayList<items> itemList = new ArrayList<items>();
    
    public items() {

    }

    public items(String name, double weight) {
		this.name = name;
        this.weight = weight;
	}

    public String getItemName() {
        return this.name;
    }
    
    public double getItemWeight() {
        return this.weight;
    }

    public void addItem(items item) {
        itemList.add(item); 
    }
}
