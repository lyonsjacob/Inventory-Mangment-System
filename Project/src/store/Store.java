package store;

import java.text.NumberFormat;

import stock.Stock;

/**
 * An object that represents the store itself. 
 * This object employs the singleton pattern 
 * and holds the stores Capital Inventory and 
 * Name.
 * 
 * @author Jacob Lyons
 *
 */
public class Store {
	
	private static Store storeInstance;
	private double capital;
	private String name = "Store";
	private static Stock stock;
	
	private Store() {
		capital = 100000.00;
	}
	
	/**
	 * Gets an instance of the store 
	 * @return storeInstance
	 * @author JacobLyons
	 */
    public static Store getInstance() {
        if (null == storeInstance) {
        	storeInstance = new Store();
        	stock = new Stock();
        }
        return storeInstance;
    }
	
    /**
     * Gets the stores capital.
     * @return double- Store capital
     * @author Jacob Lyons
     */
    public double getCapital() {
    	return this.capital;
    }

    /**
     * Sets the stores capital.
     * @param double- Store capital
     * @author Jacob Lyons
     */
	public void setCapital(double capital) {
		this.capital = capital;
	}
	

	/**
	 * Sets the stores name
	 * @param String- Store name
	 * @author Jacob Lyons
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the stores name.
	 * @return String- Store name
	 * @author Jacob Lyons
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the stores inventory
	 * @return Stock- Store inventory
	 * @author Jacob Lyons
	 */
	public Stock getInventory() {
		return stock;
	}

	
	
	/**
	 * Gets the stores capital and converts it to string 
	 * in dollar format.
	 * @return string of store capital in dollar.
	 * @author Jacob Lyons
	 */
	public String getCapitalDolarFormat() {
		
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	return formatter.format(capital);
		
	}
    
}










