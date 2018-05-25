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
	 *Constructs an item class
	 * 
	 * @param amount
	 * @param name			-name of item
	 * @param costPrice		-cost price of item
	 * @param salePrice		-sale price of item
	 * @param reorderPoint	-quantity when item requires re-stocking 
	 * @param reorderAmount	-order quantity
	 * @author Jacob lyons
	 * @throws StockException 
	 */
	public Item(int amount, String name, double costPrice, double salePrice, int reorderPoint, int reorderAmount, int temperature) throws StockException {
		
		if (costPrice < 0.0) {
			throw new StockException("Cannot set " +name+" to have negative cost price");
		}
		if (salePrice < 0.0) {
			throw new StockException("Cannot set " +name+" to have negative sale price");
		}
		if (reorderPoint < 0.0) {
			throw new StockException("Cannot set " +name+" to have negative reorder point");
		}
		if (reorderAmount < 0.0) {
			throw new StockException("Cannot set " +name+" to have negative reorder amount");
		}
		this.name = name;
		this.costPrice = costPrice;
		this.salePrice = salePrice; 
		this.reorderAmount = reorderAmount;
		this.reorderPoint = reorderPoint;
		this.temperature = temperature;
		this.amount = amount;
	}
	
	/**
	 * Constructs an item class witch does not include temperature 
	 * 
	 * @param amount
	 * @param name			-Name of item
	 * @param costPrice2	-Cost price of item
	 * @param sellPrice		-Sale price of item
	 * @param reorderPoint	-Quantity when item requires re-stocking 
	 * @param reorderAmount	-Order quantity
	 * @param temperature 	-Item temperature
	 * @author Jacob Lyons
	 * @throws StockException 
	 */
	public Item(int amount, String name, double costPrice, double salePrice, int reorderPoint, int reorderAmount) throws StockException {
		if (costPrice < 0.0) {
			throw new StockException("Cannot set " +name+" to have negative cost price");
		}
		if (salePrice < 0.0) {
			throw new StockException("Cannot set " +name+" to have negative sale price");
		}
		if (reorderPoint < 0.0) {
			throw new StockException("Cannot set " +name+" to have negative reorder point");
		}
		if (reorderAmount < 0.0) {
			throw new StockException("Cannot set " +name+" to have negative reorder amount");
		}
		this.name = name;
		this.costPrice = costPrice; 
		this.salePrice = salePrice; 
		this.reorderAmount = reorderAmount;
		this.reorderPoint = reorderPoint;
		
		
		this.amount = amount;
	}
	
	
	
	/**
	 * This method returns the name of the item.
	 * @return Name of the item in string format.
	 * @author Jacob Lyons
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method gets the cost of the item.
	 * @return Cost of item in dollars.
	 * @author Jacob Lyons
	 */
	public double getCostPrice() {
		return this.costPrice;
	}
	
	
	/**
	 * Gets the sale price of item
	 * @return Sale price of item in dollars.
	 * @author Jacob Lyons
	 */
	public double getSellPrice() {
		return this.salePrice;
	}
	
	/**
	 * Gets reorder point
	 * @return Reorder point
	 * @author Jacob Lyons
	 */
	public int getReorderPoint() {
		return this.reorderPoint;
	}
	
	/**
	 * Gets the item reorder amount.
	 * @return Item reorder amount
	 * Jacob Lyons
	 */
	public int getReorderAmount() {
		return this.reorderAmount;
	}
	
	/**
	 * Gets the temperature the item needs to be stored at.
	 * @return Item temperature or null if the item does not need to be refrigerated.
	 * @author jacob Lyons
	 */
	public Integer getTemperature() {
		if(temperature == null) {
			return null;
		}
		return this.temperature;
	}

	/**
	 * Gets the number of items in stock.
	 * @return int- quantity of this item in stock
	 * @author Jacob Lyons
	 */
	public int getAmount() {
		return this.amount;
	}

	/**
	 * The method sets the quantity of the items in stock.
	 * @param int amount -the quantity of the items in stock
	 * @author Jacob Lyons
	 */
	public void setAmount(int amount)throws StockException{
		
		if(amount < 0){
			throw new StockException("Can't Set "+getName()+" to have a negative amount");
		}
		this.amount = amount;
	}
}
