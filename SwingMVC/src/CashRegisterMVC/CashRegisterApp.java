package CashRegisterMVC;

public class CashRegisterApp {
    public static void main(String[] args) {
        Scanner s = new Scanner();
        Model m = new Model();
        View v = new View();
        Controller c = new Controller(m, v);
        s.setController(c);
    }
}
