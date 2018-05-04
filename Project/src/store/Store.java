package store;

import stock.Stock;

/**
 * An object that represents the store itself. 
 * This object employs the singleton pattern 
 * and stores the stores Capital Inventory and 
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
     */
    public double getCapital() {
    	return this.capital;
    }

    /**
     * Sets the stores capital.
     * @param double- Store capital
     */
	public void setCapital(double capital) {
		this.capital = capital;
	}

	/**
	 * Sets the stores name
	 * @param String- Store name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the stores name.
	 * @return String- Store name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the stores inventory
	 * @return Stock- Store inventory
	 */
	public Stock getInventory() {
		return stock;
	}

	/**
	 * Sets the stores inventory
	 * @param Stock- Store inventory
	 */
	public void setInventory(Stock inventory) {
		stock = inventory;
		
	}

	/**
	 * Gets the number of items in stock 
	 * 
	 * @return int -number of items in stock
	 */
	public int getAmount() {
		return stock.getStockQuantity();
	}
	
    
    
}
