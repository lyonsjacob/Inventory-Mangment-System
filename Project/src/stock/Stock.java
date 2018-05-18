package stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import exceptions.StockException;
import item.Item;

/**
 * A collection of items. Is be used to hold store inventory information.
 * 
 * @author Jacob Lyons N9507175 & Mitchell Willemse (n9470620),
 *
 */
public class Stock implements Iterable<Item>  {
	
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
	 * @exception throws exception if the same item is added twice.
	 */
	public void put(Item item)throws StockException {
		String itemName = item.getName();
		//checks the item name
		for(int i =0; i < storeStock.size(); i++) {
			if(storeStock.get(i).getName().equals(itemName)) {
				throw new StockException("Cannot add the same item twice");
			}
		}
		if(storeStock.contains(item)) {
			throw new StockException("Cannot add the same item twice");
		}
		storeStock.add(item);	
	}
	
	/**
	 * This method clears all items in the stores inventory.
	 */
	public void clear() {
		storeStock.clear();
	}

	/**
	 * Gets item object using name as key.
	 * @param string itemName - item name
	 * @return Item 
	 * @throws StockException when item is not in list.
	 */
	// note must change method name because it over rides list.get();
	public Item getItemName(String itemName)throws StockException {
		for(int i = 0; i < storeStock.size(); i++) {
			
			if(storeStock.get(i).getName().equals(itemName)) {
				return storeStock.get(i);
			}
		}
		
		throw new StockException("Item is not in list");
	}
	
	
	/**
	 * This class sets the quantity of the item
	 * 
	 * @param itemName
	 * @param quantity
	 * @throws StockException
	 */
	public void setQuantity(String itemName, int quantity) throws StockException {
		getItemName(itemName).setAmount(quantity);
	}
	
	/**
	 * This class gets the quantity of the item.
	 * 
	 * @param itemName
	 * @param quantity
	 * @throws StockException
	 */
	public int getQuantity(String itemName) throws StockException{
		return getItemName(itemName).getAmount();
	}


	/**
	 * This is an iterator for the stock collection.
	 */
	@Override
	public Iterator<Item> iterator() {
	    Iterator<Item> stockIterator = new Iterator<Item>() {
	        private int currentIndex = 0;

	        @Override
	        public boolean hasNext() {
	            return currentIndex < storeStock.size();
	        }

	        @Override
	        public Item next() {
	            return storeStock.get(currentIndex++);
	        }

	    };
	    
	    return stockIterator;
	}
}
