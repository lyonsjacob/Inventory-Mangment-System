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
	
	// is this needed?
	public Item() {
		name = "empty";
		costPrice = 0; // double?
		salePrice = 0; // double?
		reorderAmount = 0;
		reorderPoint = 0;
	}
	
	/**
	 * This is a constructor of the item class
	 * @param name			-name of item 
	 * @param costPrice		-cost price of item
	 * @param salePrice		-sale price of item
	 * @param reorderPoint	-quantity when item requires re-stocking 
	 * @param reorderAmount	- order quantity
	 */
	public Item(String name, int costPrice, int salePrice, int reorderPoint, int reorderAmount) {
		this.name = name;
		this.costPrice = costPrice; // double?
		this.salePrice = salePrice; // double?
		this.reorderAmount = reorderAmount;
		this.reorderPoint = reorderPoint;
	}
	
	

}
