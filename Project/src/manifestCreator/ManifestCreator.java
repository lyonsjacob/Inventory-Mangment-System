package manifestCreator;

import manifest.Manifest;
import ordinaryTruck.OrdinaryTruck;
import refrigeratedTruck.RefrigeratedTruck;
import stock.Stock;
import truck.Truck;

import java.util.ArrayList;
import java.util.Iterator;

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
		
		inventory.sort();
		
		for (Item i : inventory) {
			
			//Item needs to be reordered. 
			if (i.getAmount() <= i.getReorderPoint()) {
				toOrder.add(i);
			}
			
		}
		
		//Keep looping and creating trucks until toOrder is empty.
		while(!toOrder.isEmpty()) {
			
			Truck truck = new OrdinaryTruck();
			Boolean isFirst = true;
			int quantity = 0;
			
			//Create an Iterator to iterate through toOrder.
			Iterator<Item> iter =  toOrder.iterator();
			
			//Iterate through toOrder
			while (iter.hasNext()) {
				
				//Get current item.
				Item entry = iter.next();
				
				//First item for a new truck
				if (isFirst) {
					if (entry.getTemperature() != null) {
						//If item has a temperature, create Refrigerated Truck 
						truck = new RefrigeratedTruck();
						truck.addItem(entry.getName(), entry.getReorderAmount(), entry.getTemperature());
						quantity += entry.getReorderAmount();
						
					} else {
						//No temperature, create Ordinary Truck.
						truck = new OrdinaryTruck();
						truck.addItem(entry.getName(), entry.getReorderAmount());
						quantity += entry.getReorderAmount();
						
					}
					isFirst = false;
				} else {
					//truck.addItem(entry.getName(), entry.getReorderAmount());
					quantity += entry.getReorderAmount();
				}

				if (quantity > 800 || (iter.hasNext() == false)) {
					manifest.addTruck(truck);
					isFirst = true;
					quantity = 0;
					truck = null;
				}
				
				//Been placed on Truck, remove from toOrder
				iter.remove();
			}
			
		
			
			
		}
		
		

			
			
		
		return manifest;
	}

}
