package truck;

import java.util.Map;

import item.Item;

/**
 * Truck Interface class to build OrdinaryTruck and RefigeratedTruck.
 * @author Mitchell Willemse (n9470620).
 *
 */
public interface Truck {
	
	public double getCost();
	public void addItem(Item item, int Quantity);
	public int getTotalQuantity();
	public Map<Item, Integer> getHashMap();

}
