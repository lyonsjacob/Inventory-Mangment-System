package truck;

/**
 * An abstract class for a "truck" that holds quantity of items
 * and has a total price. Both refrigerated and ordinary truck inherit
 * from this class.  
 * 
 * @author Mitchell Willemse
 *
 */
public abstract class Truck {
	
	private int quantity;
	private double cost;
	
	/**
	 * Returns the quantity of items on the truck.
	 * @return The quantity of items.
	 */
	public int getTotalQuantity() {
		return this.quantity;
	}
	
	/**
	 * Returns the total cost of the truck.
	 * @return The cost.
	 */
	public double getCostTest() {
		return this.cost;
	}

}
