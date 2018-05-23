package ordinaryTruck;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import exceptions.DeliveryException;
import truck.Truck;

/**
 * Ordinary Truck. A truck, possessing the following properties:
 * – Cost in dollars equal to 750 + 0.25q where q is the total quantity of
 * items in the cargo.
 * – Cargo capacity of 1000 items.
 * – Cargo. Temperature controlled items cannot be stored in an ordinary
 * truck’s cargo, only dry goods.
 * @author Mitchell Willemse (n9470620).
 */
public class OrdinaryTruck extends Truck {
	
	private Map<String, Integer> cargo;
	private int cargoQuantity;
	private double cost;
	final int MAX_CARGO = 1000;
	
	/**
	 * A constructor that initializes the variables.
	 * @author Mitchell Willemse (n9470620).
	 */
	public OrdinaryTruck() {
		cargo = new LinkedHashMap<String, Integer>();
		cargoQuantity = 0;
	}
	
	
	
	/**
	 * Adds the both the item and the item amount to the truck. Checks to make sure that the
	 * amount of items does not exceed the the cargo limit.
	 * @param itemName The name of the item.
	 * @param amount The quantity of item.
	 * @throws DeliveryException If cargo limit is exceeded.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Override
	public void addItem(String itemName, int amount) throws DeliveryException {
		if ((cargoQuantity + amount) <= 1000) {
			cargo.put(itemName, amount);
			cargoQuantity += amount;
		} else {
			throw new DeliveryException("Cargo limit is exceeded!");
		}

	}

	
	
	
	/**
	 * Gets the total quantity of cargo currently in the truck.
	 * @return The amount of cargo.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Override
	public int getTotalQuantity() {
		return cargoQuantity;
	}

	
	
	
	/**
	 * Returns the HashMap collection of the trucks items and quantity.
	 * @return The HashMap.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Override
	public Map<String, Integer> GetMap() {
		return cargo;
	}

	
	
	
	/**
	 * Returns the cost of the truck, calculated as 750 + 0.25q 
	 * where q is the quantity of items in the cargo.
	 * @return The cost in dollars.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Override
	public double getCost() {
		cost = 750 + 0.25*cargoQuantity;
		return cost;
	}


	/**
	 * Adds an item to the refrigerated truck and sets the trucks temperature to that of
	 * the item being added.
	 * @param itemName The item to be added.
	 * @param amount The quantity of such item.
	 * @param temperature The temperature of the item.
	 * @throws DeliveryException If item has temperature and is added to ordinary truck.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Override
	public void addItem(String itemName, int amount, int temperature) throws DeliveryException {
		throw new DeliveryException("Can't add item with temperature to ordinary truck!");
	}



	/**
	 * Get the maximum number of cargo that the truck can contain.
	 * @return The max cargo amount, in this case 1000.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Override
	public int getMaxCargo() {
		return MAX_CARGO;
	}
	
	
	
	@Override
	public String convertToString() {
		//String to return.
		String output = "";
		
		output += ">Ordinary\n";
		
        for (Entry<String, Integer> entry : cargo.entrySet()){
            output += entry.getKey() + "," + entry.getValue() + "\n";
        }
    
	    //Return this string.
		return output;
	}
}
