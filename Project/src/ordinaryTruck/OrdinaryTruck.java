package ordinaryTruck;

import java.util.Map;

import truck.Truck;

/**
 * 
 * @author Mitchell Willemse
 *
 */
public class OrdinaryTruck extends Truck {
	
	private Map<String, Integer> cargo;
	private int cargoQuantity;
	private double cost;
	
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
		cost = 750 + 0.25*cargoQuantity;
		return cost;
	}

}
