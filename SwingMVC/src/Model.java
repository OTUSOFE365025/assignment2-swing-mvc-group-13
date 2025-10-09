import java.util.ArrayList;

public class Model {
    // INSTANCE VARIABLES
    private ArrayList<Product> scanned_item_by_upc = new ArrayList<>(); // arraylist to be size flexible
    private float subtotal = 0.0f; // used float because you don't need the memory space of a double as there will only be two decimal places

    // DEFAULT CONSTRUCTOR
    public Model() {

    }

    // METHODS

    // add item to scanned item list here by upc 
    public void addItem(Product product) {
        this.scanned_item_by_upc.add(product); // add product to arraylist of products
        this.subtotal += product.getPrice(); // running subtotal calculation
    }

    // getter method for subtotal
    public float getSubtotal() {
        return this.subtotal;
    }
    
    // getter method for last scanned item in arraylist
    public Product getLastScannedItem() {
        return this.scanned_item_by_upc.get(this.scanned_item_by_upc.size() - 1);
    }
}
