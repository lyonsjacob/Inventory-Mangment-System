package stock;

import java.util.ArrayList;

import item.Item;

/**
 * A collection of items. Is be used to hold store inventory information.
 * 
 * @author Jacob Lyons N9507175
 *
 */
public class Stock  {
	
	private ArrayList<Item> storeStock;

	/**
	 * Initilises an empty array list
	 */
	public Stock() {
		storeStock = new ArrayList<Item>();
	}
	
	public int getStockQuantity() {
		return storeStock.size();
	}
	
	/**
	 * Puts an item in the storeStock collection
	 * @param item
	 */
	public void put(Item item) {
		storeStock.add(item);	
	}

	/**
	 * Gets item object using name as key.
	 * @param string itemName - item name
	 * @return Item 
	 */
	public Item get(String itemName) {
		for(int i = 0; i < storeStock.size(); i++) {
			if(storeStock.get(i).getName() == itemName) {
				return storeStock.get(i);
			}
		}
		return null;
	}



	

}
