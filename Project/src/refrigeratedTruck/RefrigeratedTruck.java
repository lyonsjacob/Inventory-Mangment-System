package refrigeratedTruck;

import java.util.HashMap;
import java.util.Map;

import truck.Truck;

/**
 * 
 * @author Mitchell Willemse
 *
 */
public class RefrigeratedTruck extends Truck {
	
	private Map<String, Integer> cargo;
	private int cargoQuantity;
	private int temperature;
	private double cost;
	
	
	public RefrigeratedTruck() {
		cargoQuantity = 0;
		cargo = new HashMap<String, Integer>();
	}
	
	
	public void addItem(String itemName, int amount, int temperature) {
		this.temperature = temperature;
		this.addItem(itemName, amount);
	}
	
	public int getTemperature() {
		return temperature;
	}

	@Override
	public void addItem(String itemName, int amount) {
		cargo.put(itemName, amount);
		cargoQuantity += amount;
		
	}

	@Override
	public int getTotalQuantity() {
		return cargoQuantity;
	}

	@Override
	public Map<String, Integer> GetHashMap() {
		return cargo;
	}

	@Override
	public double getcost() {
		cost = 900 + 200.00*Math.pow(0.70, temperature/5.00);
		return cost;	
	}

}
