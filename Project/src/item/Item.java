package item;

/**
 * The class constructs an item witch stores the items name 
 * cost price, sale price, reorder point and reorder amount. 
 * @author Jacob Lyons
 */

public class Item {
	
	private String name;
	private int costPrice; // double?
	private int salePrice; // double?
	private int reorderPoint;
	private int reorderAmount;
	private int temperature;
	
	/**
	 * This is a constructor of the item class
	 * @param name			-name of item 
	 * @param costPrice		-cost price of item
	 * @param salePrice		-sale price of item
	 * @param reorderPoint	-quantity when item requires re-stocking 
	 * @param reorderAmount	- order quantity
	 */
	public Item(String name, int costPrice, int salePrice, int reorderPoint, int reorderAmount, int temperature) {
		this.name = name;
		this.costPrice = costPrice; // double?
		this.salePrice = salePrice; // double?
		this.reorderAmount = reorderAmount;
		this.reorderPoint = reorderPoint;
		this.temperature = temperature;
	}
	
	/**
	 * This method retuns the name of the item
	 * @return Name of the item.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method gets the cost of the item
	 * @return Cost of item in dollars.
	 */
	public int getCostPrice() {
		return this.costPrice;
	}
	
	/**
	 * Gets the sale price of item
	 * @return Sale price of item in dollars.
	 */
	public int getSellPrice() {
		return this.salePrice;
	}
	
	/**
	 * Gets reorder point
	 * @return Reorder point
	 */
	public int getReorderPoint() {
		return this.reorderPoint;
	}
	
	/**
	 * Gets item reorder amount
	 * @return Item reorder amount
	 */
	public int getReorderAmount() {
		return this.reorderAmount;
	}
	
	/**
	 * Gets item temperature 
	 * @return Item temperature.
	 */
	public int getTemperature() {
		return this.temperature;
	}
	
	
	public String toString() {
		
		String outPutString = this.name+", "+ this.costPrice+", "+ this.salePrice+", "
				+ ", "+ this.reorderPoint+", "+ this.reorderAmount+", "+this.temperature+"\n";
		return outPutString;
	}
	
	
	
	

}
