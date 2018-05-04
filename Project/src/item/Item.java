package item;

import exceptions.StockException;

/**
 * The class constructs an item witch stores the items name 
 * cost price, sale price, reorder point and reorder amount. 
 * @author Jacob Lyons
 */

public class Item {
	
	private int amount;
	private String name;
	private double costPrice; 
	private double salePrice;
	private int reorderPoint;
	private int reorderAmount;
	private Integer temperature;
	
	
	
	
	/**
	 * This is a constructor of the item class
	 * 
	 * @param amount
	 * @param name			-name of item
	 * @param costPrice		-cost price of item
	 * @param salePrice		-sale price of item
	 * @param reorderPoint	-quantity when item requires re-stocking 
	 * @param reorderAmount	-order quantity
	 */
	public Item(int amount, String name, double costPrice, double salePrice, int reorderPoint, int reorderAmount, int temperature) {
		this.name = name;
		this.costPrice = costPrice;
		this.salePrice = salePrice; 
		this.reorderAmount = reorderAmount;
		this.reorderPoint = reorderPoint;
		this.temperature = temperature;
		this.amount = amount;
	}
	
	/**
	 * This is a second constructor witch does not include temperature 
	 * 
	 * @param amount
	 * @param name			-Name of item
	 * @param costPrice2		-Cost price of item
	 * @param sellPrice		-Sale price of item
	 * @param reorderPoint	-Quantity when item requires re-stocking 
	 * @param reorderAmount	-Order quantity
	 * @param temperature 	-Item temperature
	 */
	public Item(int amount, String name, double costPrice2, double sellPrice, int reorderPoint, int reorderAmount) {
		this.name = name;
		this.costPrice = costPrice2; 
		this.salePrice = sellPrice; 
		this.reorderAmount = reorderAmount;
		this.reorderPoint = reorderPoint;
		
		this.amount = amount;
	}
	
	
	
	/**
	 * This method returns the name of the item
	 * @return Name of the item.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method gets the cost of the item
	 * @return Cost of item in dollars.
	 */
	public double getCostPrice() {
		return this.costPrice;
	}
	
	/**
	 * Gets the sale price of item
	 * @return Sale price of item in dollars.
	 */
	public double getSellPrice() {
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
	public Integer getTemperature() {
		if(temperature == null) {
			return null;
		}
		return this.temperature;
	}
	
	
	/**
	 * Returns a string of the items properties
	 * @return String of the items properties
	 */
	public String toString() {
		if(temperature == null) {
			String outPutString = amount+", "+ name+", "+ costPrice+", "+ salePrice+", "
					+ ", "+ reorderPoint+", "+ reorderAmount+"\n";
			return outPutString;
		}
		
		String outPutString = amount+", "+name+", "+ costPrice+", "+ salePrice+", "
				+ ", "+ reorderPoint+", "+ reorderAmount+", "+temperature+"\n";
		return outPutString;
	}

	/**
	 * Gets the number of items in stock
	 * @return int- quantity of this item in stock
	 */
	public int getAmount() {
		return this.amount;
	}

	/**
	 * The method sets the quantity of the items in stock
	 * @param int amount -the quantity of the items in stock
	 */
	public void setAmount(int amount)throws StockException{
		
		if(amount < 0){
			throw new StockException("Can't Set Negative Amount");
		}
		this.amount = amount;
	}

	
	public boolean isBelowReorderPoint() {
		if(this.amount < this.reorderAmount) {
			return true;
		}
		return false;
	}
	
	
	
	

}
