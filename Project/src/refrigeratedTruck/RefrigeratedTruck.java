package refrigeratedTruck;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import exceptions.DeliveryException;
import truck.Truck;

/**
 * Refrigerated Truck. A truck, possessing following properties:
 * – Cost in dollars equal to 900 + 200 × 0.7^(T/5)
 * where T is temperature of the truck in °C. 
 * – Cargo capacity of 800 items.
 * – Cargo. All items can be stored in a refrigerated truck’s cargo, including
 * dry goods (items that do not need to be temperature controlled).
 * – Temperature in °C that maintains a safe temperature for the truck’s
 * cargo. This is equal to the temperature of the item in the cargo with
 * the coldest safe temperature. The allowed temperature range is from
 * 20°C inclusive to 10°C inclusive.
 * @author Mitchell Willemse (n9470620).
 */
public class RefrigeratedTruck extends Truck {
	
	private Map<String, Integer> cargo;
	private int cargoQuantity;
	private Integer temperature;
	private double cost;
	final int MAX_CARGO = 800;
	
	/**
	 * A constructor that initializes the variables.
	 * @author Mitchell Willemse (n9470620).
	 */
	public RefrigeratedTruck() {
		cargoQuantity = 0;
		cargo = new LinkedHashMap<String, Integer>();
		cost = 0;
		temperature = null;
	}
	
	
	
	/**
	 * Adds an item to the refrigerated truck and sets the trucks temperature to that of
	 * the item being added.
	 * @param itemName The item to be added.
	 * @param amount The quantity of such item.
	 * @param temperature The temperature of the item.
	 * @throws DeliveryException If the cargo limit is exceeded.
	 * @author Mitchell Willemse (n9470620).
	 */
	public void addItem(String itemName, int amount, int temperature) throws DeliveryException {
		if (this.temperature != null) {
			if (temperature > this.temperature) {
				//can't set to a warmer temperature
				throw new DeliveryException("Temperature can not be set to be warmer");
			}
		}
		
		//Set the temperature for the truck
		if (temperature <= 10 && temperature >= -20) {	
			this.temperature = temperature;
			this.addItem(itemName, amount);
		} else {
			throw new DeliveryException("Temperature out of range!");
		}

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
		if (amount < 0) {
			throw new DeliveryException("Can't set negative item amount for truck!");
		}
		
		if ((cargoQuantity + amount) <= 800) {
			cargo.put(itemName, amount);
			cargoQuantity += amount;
			getCost();
		} else {
			throw new DeliveryException("Cargo limit is exceeded!");
		}
	}
	
	
	
	/**
	 * Get the current temperature of the truck.
	 * @return The temperature in °C.
	 * @author Mitchell Willemse (n9470620).
	 */
	public int getTemperature() {
		return temperature;
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
	 * Returns the cost of the truck, calculated as 900 + 200 × 0.7^(T/5)
	 * where T is temperature of the truck in °C. 
	 * @return The cost in dollars.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Override
	public double getCost() {
		cost = 900 + 200.00*Math.pow(0.70, temperature/5.00);
		return cost;	
	}



	/**
	 * Get the maximum number of cargo that the truck can contain.
	 * @return The max cargo amount, in this case 800.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Override
	public int getMaxCargo() {
		return MAX_CARGO;
	}



	/**
	 * Get the truck as a string.
	 * @return The truck and it's contents.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Override
	public String convertToString() {
		//String to return.
		String output = "";
		
		//Added truck type.
		output += ">Refrigerated\n";
		
		//Add items from truck.
        for (Entry<String, Integer> entry : cargo.entrySet()){ 
            output += entry.getKey() + "," + entry.getValue() + "\n";
        }
    
	    //Return this string.
		return output;
	}
}
