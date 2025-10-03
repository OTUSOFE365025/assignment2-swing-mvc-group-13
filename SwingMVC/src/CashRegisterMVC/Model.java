package CashRegisterMVC;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Model {
    // MODEL VARIABLES
    private ArrayList<Product> scanned_item_by_upc = new ArrayList<>(); // arraylist to be size flexible
    private float subtotal = 0.0f; // used float because you don't need the memory space of a double as there will only be two decimal places
    

    // DEFAULT CONSTRUCTOR
    public Model() {

    }

    // METHODS BELOW

    // add item to scanned item list by upc
    public void addItemByUpc(String itemUpc) {
        try {
            this.scanned_item_by_upc.add(new Product(Integer.parseInt(itemUpc.replaceAll("\\s", "")), "placeholder", 0.00f)); // enters with placeholder first to ensure that the upc code is all integer
        } catch(NumberFormatException e) {
            System.err.println("Error: Cannot convert string to int. " + e.getMessage() + "\n Please enter a valid upc code.");
            return;
        }
        // passing validation of upc code
        BufferedReader reader = null;
        boolean not_found = true;
        try {
            reader = new BufferedReader(new FileReader("SwingMVC/src/CashRegisterMVC/file.txt")); // file path goes here
            reader.readLine(); // skips first line because it just contains the total amount of products
            String line;
            while((line = reader.readLine()) != null) {
                String[] line_arr = line.split(" "); // split line by space and put into array
                if(this.scanned_item_by_upc.get(this.scanned_item_by_upc.size() - 1).getUpc() == Integer.parseInt(line_arr[0].trim())) {// take white space out just in case, and compare upc
                    this.scanned_item_by_upc.get(this.scanned_item_by_upc.size() - 1).setName(line_arr[1].trim()); // overwrite placeholder name
                    this.scanned_item_by_upc.get(this.scanned_item_by_upc.size() - 1).setPrice(Float.parseFloat(line_arr[2].trim())); // overwrite placeholder price
                    this.subtotal += Float.parseFloat(line_arr[2].trim()); // increment subtotal
                    not_found = false; // we found the item by upc
                    return;
                }
            }
        } catch (IOException e) { // catches error reading file
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        } finally { // after finishing in all cases, close the buffered reader
            try {
                if(not_found)
                    System.out.println("UPC code not found."); // flexible for future integration of user upc code entry
                if(reader != null)
                    reader.close();
            } catch(IOException e) { // if cannot close buffered reader
                System.out.println("Error closing the reader.");
                e.printStackTrace();
            }
        }
    }

    // recalculates subtotal ??? this may be useless, but I can see a use in recalculating subtotal because of some edge case not being covered
    public void recalculateSubtotal() {
        this.subtotal = 0.0f;
        for(Product product : this.scanned_item_by_upc) 
            this.subtotal += product.getPrice();
    }

    // getter method for subtotal
    public float getSubtotal() {
        return this.subtotal;
    }
    
    // getter method for last scanned item
    public Product getLastScannedItem() {
        return this.scanned_item_by_upc.get(this.scanned_item_by_upc.size() - 1);
    }

}
