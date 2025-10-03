package CashRegisterMVC;

import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class View {
    private JFrame frame;
    private JList<String> list;
    private JScrollPane scroll_pane;
    private JLabel label;
    private DefaultListModel<String> list_model;
    
    public View() {
        // create JList and the list_model specifying the contents
        list_model = new DefaultListModel<>();
        list = new JList<>(list_model);
        list.setFont(new Font("Monospaced", Font.PLAIN, 12)); // set font to monospaced so the spacings of String.format work well

        // make it scrollable by putting it in a JScrollPane
        scroll_pane = new JScrollPane(list);
        scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        label = new JLabel("Subtotal: 0");

        // create JFrame
        frame = new JFrame("Scrollable List Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // add to frame
        frame.setLayout(new BorderLayout());
        frame.add(scroll_pane, BorderLayout.CENTER);
        frame.add(label, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void updateList(Product product, float subtotal) {
        String formatted = String.format("%-10s %-15s %6.2f", product.getUpc(), product.getName(), product.getPrice()); // %-10s - left-align in a 10-character field, %-15s - left-align name in 15-character field, %6.2f - price right-aligned in 6-character field with 2 decimals
        DecimalFormat df = new DecimalFormat("#0.00"); // format to two decimal places because direct casting of float to int causes some issues
        this.list_model.addElement(formatted); // list model increment element
        this.list.setModel(this.list_model);
        this.label.setText("Subtotal: " + df.format(subtotal));
    }
}
