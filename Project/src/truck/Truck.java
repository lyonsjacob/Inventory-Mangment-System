package truck;
import java.util.Map;

import exceptions.DeliveryException;

/**
 * An abstract class for the two truck types.
 * @author Mitchell Willemse
 *
 */
public abstract class Truck {
	/**
	 * Adds the both the item and the item amount to the truck. Checks to make sure that the
	 * amount of items does not exceed the the cargo limit.
	 * @param itemName The name of the item.
	 * @param amount The quantity of item.
	 * @throws DeliveryException If cargo limit is exceeded.
	 */
	public abstract void addItem(String itemName, int amount) throws DeliveryException;
	
	/**
	 * Gets the total quantity of cargo currently in the truck.
	 * @return The amount of cargo.
	 */
	public abstract int getTotalQuantity();
	
	/**
	 * Returns the HashMap collection of the trucks items and quantity.
	 * @return The HashMap.
	 */
	public abstract Map<String, Integer> GetHashMap();
	
	/**
	 * Returns the cost of the truck, calculated differently depending whether it is
	 * refrigerated or not.
	 * @return The cost in dollars.
	 */
	public abstract double getCost();
	
	/**
	 * Adds an item to the refrigerated truck and sets the trucks temperature to that of
	 * the item being added.
	 * @param itemName The item to be added.
	 * @param amount The quantity of such item.
	 * @param temperature The temperature of the item.
	 * @throws DeliveryException If the cargo limit is exceeded.
	 */
	public abstract void addItem(String itemName, int amount, int temperature) throws DeliveryException;
	
}
