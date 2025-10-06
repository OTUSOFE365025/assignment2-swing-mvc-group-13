public class Product {
    // INSTANCE VARIABLES
    private int upcCode;
    private String name;
    private float price;

    // CONSTRUCTOR
    public Product(int upcCode, String name, float price) {
        this.upcCode = upcCode;
        this.name = name;
        this.price = price;
    }

    // BASIC GETTERS AND SETTERS
    public void setUpc(int upcCode) {
        this.upcCode = upcCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getUpc() {
        return this.upcCode;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }
}
