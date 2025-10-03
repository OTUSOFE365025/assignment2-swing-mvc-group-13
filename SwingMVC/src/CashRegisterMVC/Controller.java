package CashRegisterMVC;

public class Controller {
    private Model model;
	private View view;
	 
	public Controller(Model m, View v) {
        this.model = m;
        this.view = v;
	}

    public void receiveGeneratedUpcCode(String upcCode) {
        this.model.addItemByUpc(upcCode);
        updateView(this.model.getLastScannedItem(), this.model.getSubtotal());
    }

    public void updateView(Product product, float subtotal) {
        this.view.updateList(product, subtotal);
    }
}
