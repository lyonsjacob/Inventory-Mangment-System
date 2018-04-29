package stock;

import item.Item;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/***
 * The following tests are for the basic functionality of
 * the Stock class.
 * 
 *  A collection of items. Can be used for representing store inventory,
 *  stock orders, sales logs, and truck cargo.
 * 
 * @author Mitchell Willemse
 *
 */
public class StockTest {
	
	//Test 0: Declaring Stock object.
	Stock stock;

	//Test 1: Constructing an empty Stock object.
	@Before @Test
	public void setUpStock() {
		stock = new Stock();
	}
	
	//Test 2: Add Item.
	@Test
	public void addItem() {
		Item testItem = new Item("Ice Cream", 3, 4, 300, 400, -20);
		int quantity = 500; //Number of items
		stock.addItem(testItem, quantity);

		assertEquals(quantity, stock.getQuantity(testItem));
	}
	
	//Test 3: Set Quantity.
	@Test
	public void setQuantity() {
		Item testItem = new Item("Ice Cream", 3, 4, 300, 400, -20);
		stock.addItem(testItem, 0);
		int newQuantity = 700;
		stock.setQuantity(testItem, newQuantity);
		
		assertEquals(newQuantity, stock.getQuantity(teastItem));
	}
	
	//Test 4: Can't Add Same Item Twice.
	@Test (expected = Exception.class)
	public void duplicateItem() {
		Item testItem = new Item("Ice Cream", 3, 4, 300, 400, -20);
		stock.addItem(testItem, 0);
		stock.addItem(testItem, 0);
	}
	
	//Test 5: Can't Have Negative Quantity.
	@Test (expected = Exception.class)
	public void negativeQuantity() {
		Item testItem = new Item("Ice Cream", 3, 4, 300, 400, -20);
		stock.addItem(testItem, 0);
		stock.setQuantity(testItem, -5);
	}
	
	//Test 6: Can't Set Quantity for Non-Existent Item.
	@Test (expected = Exception.class) 
	public void unkmownItem() {
		Item testItem = new Item("Ice Cream", 3, 4, 300, 400, -20);
		stock.setQuantity(testItem, 500);
	}
	
	//Test 7: Get Item By Name.
	@Test
	public void getItemByName() {
		Item testItem1 = new Item("Ice Cream", 3, 4, 300, 400, -20);
		Item testItem2 = new Item("Coffee", 2, 3, 200, 225, null);
		stock.addItem(testItem1, 500);
		stock.addItem(testItem2, 500);
		
		assertEquals(testItem1, stock.getItem("Ice Cream"));
	}
	
	//Test 8: Print Items in Stock Along with Quantity
	@Test
	public void printItems() {
		Item testItem1 = new Item("Ice Cream", 3, 4, 300, 400, -20);
		Item testItem2 = new Item("Coffee", 2, 3, 200, 225, null);
		Item testItem3 = new Item("Milk", 3, 4, 100, 150, 3);
		
		stock.addItem(testItem1, 500);
		stock.addItem(testItem2, 1000);
		stock.addItem(testItem3, 1500);
		
		String expectedTest = 
				"Ice Cream, 500\n"
				+ "Coffee, 1000\n"
				+ "Milk, 1500\n";
		
		assertEquals(expectedTest, stock.toString());
	}
}
