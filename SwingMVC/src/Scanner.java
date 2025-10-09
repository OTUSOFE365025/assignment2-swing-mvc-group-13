import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Scanner {
	// Scanner uses Swing framework to create a UPC code
	 private JFrame frame;
	 private JPanel scannerPanel;
	 private JButton scanButton;
	 private Controller c;
	 
	 public Scanner() {
		  frame = new JFrame("Scanner");
		  frame.getContentPane().setLayout(new BorderLayout());
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(100, 100);
		  frame.setLocation(300,50);
		  frame.setVisible(true);
		  
		  
		  // Create UI elements
		  scanButton = new JButton("Scan");
		  scannerPanel = new JPanel();
		  
		  // Add UI element to frame
		  scannerPanel.add(scanButton);
		  frame.getContentPane().add(scannerPanel);
		  
		  scanButton.addActionListener(e -> generateUPC()); // action listener for button press function call
	 }

	private void generateUPC() {
		BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("SwingMVC/src/file.txt")); // file path goes here

			// first line is used to get number of products in the text file
            String line = reader.readLine();
            int counter = 2;

			// use Random to get random values for int from 1 to 51
			Random random = new Random();
			final int product_amount = Integer.parseInt(line.trim()); // set the max amount that random can go to(first line of file);
			int boundedRandomNumber = random.nextInt(product_amount) + 2; // get a random number 2 through 52 corresponding to the lines

			// check file line by line
            while ((line = reader.readLine()) != null) {
                String[] line_arr = line.split(" ");
                if(counter == boundedRandomNumber) { // find the randomly generated integer's line
					if(c != null) { // in case c is not set yet
						Product product = new Product(Integer.parseInt(line_arr[0].trim()), line_arr[1].trim(), Float.parseFloat(line_arr[2].trim()));
						String formatted = String.format("%-10s %-15s %6.2f", product.getUpc(), product.getName(), product.getPrice()); // %-10s - left-align in a 10-character field, %-15s - left-align name in 15-character field, %6.2f - price right-aligned in 6-character field with 2 decimals
						System.out.println(formatted);
						c.receiveProductGeneratedFromUpc(product);
						return;
					} else {
						System.out.println("Controller is not set.");
						return;
					}
				}
					
				counter++;
            }
        } catch (IOException e) { // catches error reading file
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        } finally { // after finishing in all cases, close the buffered reader
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) { // if cannot close buffered reader
                System.out.println("Error closing the reader.");
                e.printStackTrace();
            }
        }
		if(c != null)
			c.receiveProductGeneratedFromUpc(new Product(12345, "Coffee", 8.32f)); // default upc code is coffee if something goes wrong
		else
			System.out.println("Controller is not set."); // fallback if controller is not set
		System.out.println("Something went wrong with generating a random upc code from file, please try again."); // for debug purposes if need be
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getScannerPanel() {
		return scannerPanel;
	}

	public void setScannerPanel(JPanel scannerPanel) {
		this.scannerPanel = scannerPanel;
	}

	public JButton getScanButton() {
		return scanButton;
	}

	public void setScanButton(JButton scanButton) {
		this.scanButton = scanButton;
	}

	// set controller reference via parameter passed in function
	public void setController(Controller c) {
		this.c = c;
	}
}
