public class Controller {
    // INSTANCE VARIABLES
    private Model model;
	private View view;
	
    // CONSTRUCTOR
	public Controller(Model m, View v) {
        this.model = m;
        this.view = v;
	}

    // METHODS

    // receives product generated from upc code from scanner and updates view accordingly
    public void receiveProductGeneratedFromUpc(Product product) {
        this.model.addItem(product);
        updateView(this.model.getLastScannedItem(), this.model.getSubtotal());
    }

    // updates JList and subtotal label in view
    public void updateView(Product product, float subtotal) {
        this.view.updateList(product, subtotal);
    }
}
