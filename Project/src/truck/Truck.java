package truck;
import java.util.Map;

/**
 * An abstract class for a "truck".
 * @author Mitchell Willemse
 *
 */
public abstract class Truck {
	
	public abstract void addItem(String itemName, int amount);
	public abstract int getTotalQuantity();
	public abstract Map<String, Integer> GetHashMap();
	public abstract double getcost();
	
}
