import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class View {
    // INSTANCE VARIABLES
    private JFrame frame;
    private JList<String> list;
    private JScrollPane scroll_pane;
    private JLabel label;
    private DefaultListModel<String> list_model;
    
    // CONSTRUCTOR
    public View() {
        // create JList and the list_model specifying the contents
        list_model = new DefaultListModel<>();
        list = new JList<>(list_model);
        list.setFont(new Font("Monospaced", Font.PLAIN, 12)); // set font to monospaced so the spacings of String.format work well

        // make it scrollable by putting it in a JScrollPane
        scroll_pane = new JScrollPane(list);
        scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // adding scroll bars
        scroll_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        label = new JLabel("Subtotal: 0"); // label to show subtotal

        // create JFrame
        frame = new JFrame("Scrollable List Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200); // default size

        // add to frame
        frame.setLayout(new BorderLayout()); // border layout for formatting label and scroll pane
        frame.add(scroll_pane, BorderLayout.CENTER); // scroll pane in center
        frame.add(label, BorderLayout.SOUTH); // label on bottom

        frame.setVisible(true); // make frame visible, default is false
    }

    // METHODS

    // update JList and subtotal label
    public void updateList(Product product, float subtotal) {
        String formatted = String.format("%-10s %-15s %6.2f", product.getUpc(), product.getName(), product.getPrice()); // %-10s - left-align in a 10-character field, %-15s - left-align name in 15-character field, %6.2f - price right-aligned in 6-character field with 2 decimals
        DecimalFormat df = new DecimalFormat("#0.00"); // format to two decimal places because direct casting of float to int causes some issues where label will show weird values outside of 2 decimal places
        this.list_model.addElement(formatted); // list model increment element
        this.list.setModel(this.list_model); // update JList model
        this.label.setText("Subtotal: " + df.format(subtotal)); // update subtotal label text
    }
}
