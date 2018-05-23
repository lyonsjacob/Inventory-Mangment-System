package manifestCreator;

import manifest.Manifest;
import ordinaryTruck.OrdinaryTruck;
import refrigeratedTruck.RefrigeratedTruck;
import stock.Stock;
import truck.Truck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

import exceptions.DeliveryException;
import exceptions.StockException;
import item.Item;


/**
 * Creates trucks based on items needed to be ordered and puts them
 * in a manifest.
 * @author Mitchell Willemse 
 */
public class ManifestCreator {
	
	/**
	 * Creates an optimized manifest of trucks based on the given inventory. This
	 * will look at the reorder points and the amount of each item in the inventory and
	 * decide whether an item needs to be reordered. This will create a list of items that need
	 * to be ordered and creates a series of trucks. The items will be strategically added to trucks
	 * and then added to the manifest.
	 * @param inventory The inventory to look at.
	 * @return The created manifest full of trucks.
	 * @throws StockException 
	 * @throws DeliveryException 
	 * @author Mitchell Willemse
	 */
	public static Manifest CreateManifest(Stock inventory) throws StockException, DeliveryException {
		Manifest manifest = new Manifest();
		ArrayList<Item> toOrder = new ArrayList<Item>();
		
		for (Item i : inventory) {
			
			//Item needs to be reordered. 
			if (i.getAmount() <= i.getReorderPoint()) {
				toOrder.add(i);
			}
			
		}
		
		//If there are no items to order, no manifest is needed.
		if (toOrder.isEmpty()) {
			return null;
		}
		
		Truck truck = null;
		Boolean isFirst = true;
		int quantity = 0;

		//Iterate through to order.
		while (!toOrder.isEmpty()) {
			
			//Sort toOrder
			Comparator<Item> stockCompare = new Comparator<Item>() {

				@Override
				public int compare(Item o1, Item o2) {
					Integer item1 = o1.getTemperature();
					Integer item2 = o2.getTemperature();
					
					//N.B. If the temperature is null, the order of these items don't matter
					//as long as they are at the bottom. 1000 is outside the temperature range and
					//ensures the comparator puts these items last.
					if (item1 == null) {
						item1 = 1000;
					}
					if(item2 == null) {
						item2 = 1000;
					}
					
					return item1.compareTo(item2);
				}
				
			};

			toOrder.sort(stockCompare);
			
			//Get Current Item.
			Item currentItem = toOrder.get(0);
			
			//If it is first item, have to initialize truck. 
			if (isFirst) {
				
				//No temperature, create Ordinary Truck.
				if (currentItem.getTemperature() == null) {	
					truck = new OrdinaryTruck();
					truck.addItem(currentItem.getName(), currentItem.getReorderAmount());
					quantity = currentItem.getReorderAmount();
							
				//Has a temperature, create Refrigerated Truck.
				} else {
					truck = new RefrigeratedTruck();
					truck.addItem(currentItem.getName(), currentItem.getReorderAmount(), currentItem.getTemperature());
					quantity = currentItem.getReorderAmount();
					
				}
				
				//First item added.
				isFirst = false;
				toOrder.remove(currentItem);
				

			//Not first item, add to truck already initialized.
			} else {

				//Make sure we don't breach limit.
				if (quantity + currentItem.getReorderAmount() > truck.getMaxCargo()) {
					
					//First we must check if we can split the item.
					if (truck.getMaxCargo() - quantity > 0 ) {
						int leftOverSpace = truck.getMaxCargo() - quantity;
						
						truck.addItem(currentItem.getName(), leftOverSpace);
					}
					
					int newReorderAmount = currentItem.getReorderAmount() - (truck.getMaxCargo() - quantity);
					isFirst = true;
					quantity = 0;
					manifest.addTruck(truck);
					truck = null;

					Item newItem;
					
					if(currentItem.getTemperature() == null) {
						newItem = new Item(currentItem.getAmount(), currentItem.getName(), currentItem.getCostPrice(), currentItem.getSellPrice(), currentItem.getReorderPoint(), newReorderAmount);
					} else {
						newItem = new Item(currentItem.getAmount(), currentItem.getName(), currentItem.getCostPrice(), currentItem.getSellPrice(), currentItem.getReorderPoint(), newReorderAmount, currentItem.getTemperature());
					}
					
					toOrder.add(newItem);
					
					toOrder.remove(currentItem);
					
									

					
				//We can add the item.
				} else {
					truck.addItem(currentItem.getName(), currentItem.getReorderAmount());
					quantity += currentItem.getReorderAmount();
					
					//Remove from list.
					toOrder.remove(currentItem);
				}
				
			}

		}
		
		//No more items
		if (toOrder.isEmpty()) {
			isFirst = true;
			quantity = 0;
			manifest.addTruck(truck);
			truck = null;
		}
		

		return manifest;
	}

}
