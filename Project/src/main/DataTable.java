package main;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import item.Item;
import store.Store;



public class DataTable{
	// get instance of store
	Store store = Store.getInstance();
	private static DataTable tableInstance;
	// create object of table and table model
	static JTable tblInventory = new JTable();
	static DefaultTableModel dtm = new DefaultTableModel(0, 0);
	
	
	
	
	
	private DataTable() {
	}
	
	
	/**
	 * Gets an instance of the store 
	 * @return storeInstance
	 */
    public static DataTable getInstance() {
        if (null == tableInstance) {
        	tableInstance = new DataTable();

    	    // add header of the table
    	    String header[] = new String[] {"Amount",
    	           "Item",
    	           "Cost Price",
    	           "Sell Price",
    	           "Reorder Point",
    	           "Reorder Amount",
    	           "Temperature"}; //Columns.

    	    // add header in table model     
    	    dtm.setColumnIdentifiers(header);
    	    //set model into the table object
    	    tblInventory.setModel(dtm);
        }
        return tableInstance;
    }
	  
	  
	public JTable getTable() {
		return tblInventory;
	}
	
	public void updateTable(){
		// remove elements from table 
		dtm.getDataVector().removeAllElements();
		// add new elements to table      
	    for (Item i : store.getInventory()) {
	    	
	    	dtm.addRow(new Object[] { i.getAmount(), i.getName(), i.getCostPrice(), i.getSellPrice(),
	                i.getReorderPoint(), i.getReorderAmount(), i.getTemperature() });
	    }
	}
   
    
}
