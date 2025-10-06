public class CashRegisterApp {
    public static void main(String[] args) {
        Scanner s = new Scanner();
        Model m = new Model();
        View v = new View();
        Controller c = new Controller(m, v); // set model and view
        s.setController(c); // give scanner a reference to the controller
    }
}
