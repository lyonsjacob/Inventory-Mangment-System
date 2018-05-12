package main;

import java.awt.*;
import javax.swing.*;
import exceptions.*;
import item.Item;
import manifest.Manifest;
import store.Store;
import stock.Stock;
import manifestCreator.ManifestCreator;

/**
 * The main class containing the code to create, setup and display the GUI and 
 * begin the main loop. 
 * @author Mitchell Willemse & Jacob Lyons.
 *
 */
@SuppressWarnings("serial")
public class Main extends JFrame {
	
	/**
	 * Setup the GUI components and display the window. Creates the panel, 
	 * four buttons, a label and the table. 
	 * @author Mitchell Willemse (n9470620).
	 */
	public Main() {
        super("CAB302 Inventory Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
     
        //Add Panel.
        JPanel panel = new JPanel();
        
        //Add Label.
        JLabel lblCapital = new JLabel("Capital: $100,000.00");
        
        //Add Buttons.
        JButton btnLoadItem = new JButton("Load Items");
        JButton btnExportManifest = new JButton("Export Manifest");
        JButton btnLoadManifest = new JButton("Load Manifest");
        JButton btnLoadSales = new JButton("Load Sales Log");
        
        //Add Action Listeners.
        btnLoadItem.addActionListener(new LoadListener());
        btnExportManifest.addActionListener(new ExportManifestListener());
        btnLoadManifest.addActionListener(new LoadManifestListener());
        btnLoadSales.addActionListener(new LoadSalesListener());
        
        //Add Table.
        String[] columnNames = {"Amount",
                "Item",
                "Cost Price",
                "Sell Price",
                "Reorder Point",
                "Reorder Amount",
                "Temperature"}; //Columns.
        
        Object[][] data = 
        	{{"100","Milk","3.0","4.0","300","400","4"}}; //Sample Data.
        
        JTable tblInventory = new JTable(data, columnNames);
        JScrollPane scrlPane = new JScrollPane();
        scrlPane.add(tblInventory);
        scrlPane.setViewportView(tblInventory);
        
        //Add Components To Panel.
        panel.add(lblCapital);
        panel.add(btnLoadItem);
        panel.add(btnExportManifest);
        panel.add(btnLoadManifest);
        panel.add(btnLoadSales);
        panel.add(scrlPane).setPreferredSize(new Dimension(680,400));
        
        //Add Panel to Window.
        getContentPane().add(panel);
        
        //Display the window. 
        setResizable(false);
        setPreferredSize(new Dimension(720, 480));
        setLocation(new Point(200, 200));
        pack(); 
        setVisible(true); 
	}

	
	
	/**
	 * The entry point of the program, where the program control starts and ends.
	 * @param args The command-line arguments.
	 * @throws StockException 
	 * @throws DeliveryException 
	 * @author Mitchell Willemse & Jacob Lyons
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Main();	
	}
	
}
