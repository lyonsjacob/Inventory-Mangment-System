package ordinaryTruck;

import java.util.HashMap;
import java.util.Map;

import exceptions.DeliveryException;
import truck.Truck;

/**
 * Ordinary Truck. A truck, possessing the following properties:
 * – Cost in dollars equal to 750 + 0.25q where q is the total quantity of
 * items in the cargo.
 * – Cargo capacity of 1000 items.
 * – Cargo. Temperature controlled items cannot be stored in an ordinary
 * truck’s cargo, only dry goods.
 * @author Mitchell Willemse
 */
public class OrdinaryTruck extends Truck {
	
	private Map<String, Integer> cargo;
	private int cargoQuantity;
	private double cost;
	final int MAX_CARGO = 1000;
	
	/**
	 * A constructor that initializes the variables.
	 */
	public OrdinaryTruck() {
		cargo = new HashMap<String, Integer>();
		cargoQuantity = 0;
	}
	
	
	
	/**
	 * Adds the both the item and the item amount to the truck. Checks to make sure that the
	 * amount of items does not exceed the the cargo limit.
	 * @param itemName The name of the item.
	 * @param amount The quantity of item.
	 * @throws DeliveryException If cargo limit is exceeded.
	 */
	@Override
	public void addItem(String itemName, int amount) throws DeliveryException {
		if ((cargoQuantity + amount) <= 1000) {
			cargo.put(itemName, amount);
			cargoQuantity += amount;
		} else {
			throw new DeliveryException();
		}

	}

	
	
	
	/**
	 * Gets the total quantity of cargo currently in the truck.
	 * @return The amount of cargo.
	 */
	@Override
	public int getTotalQuantity() {
		return cargoQuantity;
	}

	
	
	
	/**
	 * Returns the HashMap collection of the trucks items and quantity.
	 * @return The HashMap.
	 */
	@Override
	public Map<String, Integer> GetHashMap() {
		return cargo;
	}

	
	
	
	/**
	 * Returns the cost of the truck, calculated as 750 + 0.25q 
	 * where q is the quantity of items in the cargo.
	 * @return The cost in dollars.
	 */
	@Override
	public double getCost() {
		cost = 750 + 0.25*cargoQuantity;
		return cost;
	}

}
