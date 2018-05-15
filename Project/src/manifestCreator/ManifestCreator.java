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
		
		Truck truck = null;
		Boolean isFirst = true;
		int quantity = 0;

		//Create an Iterator to iterate through toOrder.
		Iterator<Item> iter =  toOrder.iterator();
		
		
		
		//Iterate through to order.
		while (iter.hasNext()) {
			
			//Get Current Item.
			Item entry = iter.next();
			
			//If it is first item, have to initialize truck. 
			if (isFirst) {
				
				//No temperature, create Ordinary Truck.
				if (entry.getTemperature() == null) {	
					truck = new OrdinaryTruck();
					truck.addItem(entry.getName(), entry.getReorderAmount());
					quantity = entry.getReorderAmount();
							
				//Has a temperature, create Refrigerated Truck.
				} else {
					truck = new RefrigeratedTruck();
					truck.addItem(entry.getName(), entry.getReorderAmount(), entry.getTemperature());
					quantity = entry.getReorderAmount();
					
				}
				
				//First item added.
				isFirst = false;
				iter.remove();
				

			//Not first item, add to truck already initialized.
			} else {

				//Make sure we don't breach limit.
				if (quantity + entry.getReorderAmount() > truck.getMaxCargo() || iter.hasNext() == false) {
					isFirst = true;
					quantity = 0;
					manifest.addTruck(truck);
					truck = null;
					
					//Reset Iterator
					iter = toOrder.iterator();
					
					
				//We can add the item.
				} else {
					truck.addItem(entry.getName(), entry.getReorderAmount());
					quantity += entry.getReorderAmount();
					
					//Remove from list.
					iter.remove();
				}
				
			}
			
			

		}
		

		return manifest;
	}

}
