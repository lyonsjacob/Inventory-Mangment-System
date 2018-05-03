package stock;

import item.Item;
import exceptions.StockException;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

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
	Map stock;

	//Test 1: Constructing an empty Stock object.
	@Before @Test
	public void setUpStock() {
		stock = new Stock<Item, Integer>();
	}
	
	//Test 2: Add Item.
	@Test
	public void addItem() {
		Item testItem = new Item("Ice Cream", 3, 4, 300, 400, -20);
		int quantity = 500; //Number of items
		stock.put(testItem, quantity);

		assertEquals(quantity, stock.getQuantity(testItem));
	}
	
	//Test 3: Set Quantity.
	@Test
	public void setQuantity() {
		Item testItem = new Item("Ice Cream", 3, 4, 300, 400, -20);
		stock.put(testItem, 0);
		int newQuantity = 700;
		stock.setQuantity(testItem, newQuantity);
		
		assertEquals(newQuantity, stock.getQuantity(testItem));
	}
	
	//Test 4: Can't Add Same Item Twice.
	@Test (expected = StockException.class)
	public void duplicateItem() throws StockException {
		Item testItem = new Item("Ice Cream", 3, 4, 300, 400, -20);
		stock.put(testItem, 0);
		stock.put(testItem, 0);
	}
	
	//Test 5: Can't Have Negative Quantity.
	@Test (expected = StockException.class)
	public void negativeQuantity() throws StockException {
		Item testItem = new Item("Ice Cream", 3, 4, 300, 400, -20);
		stock.put(testItem, 0);
		stock.put(testItem, -5);
	}
	
	//Test 6: Can't Set Quantity for Non-Existent Item.
	@Test (expected = StockException.class) 
	public void unkmownItem() throws StockException {
		Item testItem = new Item("Ice Cream", 3, 4, 300, 400, -20);
		stock.setQuantity(testItem, 500);
	}
	
	//Test 7: Get Item By Name.
	@Test
	public void getItemByName() {
		Item testItem1 = new Item("Ice Cream", 3, 4, 300, 400, -20);
		Item testItem2 = new Item("Coffee", 2, 3, 200, 225, null);
		stock.put(testItem1, 500);
		stock.put(testItem2, 500);
		
		assertEquals(testItem1, stock.get("Ice Cream"));
	}
	
	//Test 8: Test Iterator 
	@Test
	public void testIterator() {
		Item testItem1 = new Item("Ice Cream", 3, 4, 300, 400, -20);
		Item testItem2 = new Item("Coffee", 2, 3, 200, 225, null);
		Item testItem3 = new Item("Milk", 3, 4, 100, 150, 3);
		
		stock.put(testItem1, 500);
		stock.put(testItem2, 1000);
		stock.put(testItem3, 1500);
		
		String expectedOutput = "Ice Cream500Coffee1000Milk1500 ";
		String actualOutput = "";
		
		for (Map.Entry<Item, Integer> entry : stock.entrySet()) {
			actualOutput += entry.getKey().getName();
			actualOutput += entry.getValue();
		}
		
	    
		assertEquals(expectedOutput, actualOutput);
	}
}
