package main;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	public Main() {
        super("CAB302 Inventory Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
     
        //Add Panel
        JPanel panel = new JPanel();
        
        //Add Label
        JLabel lblCapital = new JLabel("Capital: $100,000.00");
        
        //Add Buttons
        JButton btnLoadItem = new JButton("Load Items");
        JButton btnExportManifest = new JButton("Export Manifest");
        JButton btnLoadManifest = new JButton("Load Manifest");
        JButton btnLoadSales = new JButton("Load Sales Log");
        
        //Add Table
        String[] columnNames = {"Amount",
                "Item",
                "Cost Price",
                "Sell Price",
                "Reorder Point",
                "Reorder Amount",
                "Temperature"};
        
        Object[][] data = {{"","","","","","",""}};
        
        JTable tblInventory = new JTable(data, columnNames);
        
        //Add To Panel
        panel.add(lblCapital);
        panel.add(btnLoadItem);
        panel.add(btnExportManifest);
        panel.add(btnLoadManifest);
        panel.add(btnLoadSales);
        panel.add(tblInventory);
        
        //Add Panel to Window
        getContentPane().add(panel);
        
        //Display the window. 
        setPreferredSize(new Dimension(640, 480));
        setLocation(new Point(200, 200));
        pack(); 
        setVisible(true); 
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Main();
	}

}
