package refrigeratedTruck;

import java.util.Map;

import item.Item;
import truck.Truck;

/**
 * 
 * @author Mitchell Willemse
 *
 */
public class RefrigeratedTruck implements Truck {

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addItem(Item item, int Quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<Item, Integer> getHashMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getTemperature() {
		return 0;
	}

}
