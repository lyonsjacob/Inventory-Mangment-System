package main;


import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import item.Item;
import store.Store;


/**
 * This class uses a singleton pattern to create a JTable and 
 * a JLable witch holds the items details and the stores 
 * capital for the GUI. The class also allows the table and 
 * label to be dynamically updated.
 * 
 * @author Jacob lyons 
 */
public class UpdateGUIElements{
	// Get instance of store.
	Store store = Store.getInstance();
	private static UpdateGUIElements updateGUIElements;
	
	// Create object for table and table model.
	static JTable tblInventory = new JTable();
	static DefaultTableModel dtm = new DefaultTableModel(0, 0);
	
	// Capital Label
	private static JLabel capitalLabel;
	
	private UpdateGUIElements() {	
		
	}
	
	
	
	/**
	 * Gets an instance of the datatable 
	 * @return DataTable Instance
	 * @author Jacob lyons
	 */
    public static UpdateGUIElements getInstance() {
        if (null == updateGUIElements) {
        	updateGUIElements = new UpdateGUIElements();
    	    // Add header of the table
    	    String header[] = new String[] {"Amount",
    	           "Item",
    	           "Cost Price",
    	           "Sell Price",
    	           "Reorder Point",
    	           "Reorder Amount",
    	           "Temperature"}; //Columns.

    	    //Add header in table model     
    	    dtm.setColumnIdentifiers(header);
    	    //set model into the table object
    	    tblInventory.setModel(dtm);
    	    //Initialize Capital label
        	capitalLabel = new JLabel("Capital: $100,000.00");
        }
        return updateGUIElements;
    }
	 
    /**
     * Gets the Jtable.
     * @return the Jtable holding item properties.
     * @author Jacob Lyons
     */
	public JTable getTable() {
		return tblInventory;
	}

	/**
	 * This method clears the Jtable and refills the table with the items properties. 
	 * @author Jacob Lyons
	 */
	public void updateTable(){
		// remove elements from table 
		dtm.getDataVector().removeAllElements();
		// add new elements to table      
	    for (Item i : store.getInventory()) {
	    	
	    	dtm.addRow(new Object[] { i.getAmount(), i.getName(), i.getCostPrice(), i.getSellPrice(),
	                i.getReorderPoint(), i.getReorderAmount(), i.getTemperature() });
	    }
	}
	
	/**
	 * Gets the store capital JLable stored in UpdateGUIElements.
	 * 
	 * @return JLable, displaying the stores capital. 
	 * @author Jacob Lyons
	 */
	public JLabel getCaptalLabel() {
		return capitalLabel;
	}
   
	
	/**
	 * Updates the Store capital label.
	 * @author Jacob Lyons
	 */
    public void updateLable() {
    	capitalLabel.setText("Capital: " +store.getCapitalDolarFormat());
    }
}
