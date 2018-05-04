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
	Stock stock;

	//Test 1: Constructing an empty Stock object.
	@Before @Test
	public void setUpStock() {
		stock = new Stock();
	}
	
	//Test 2: Add Item.
	@Test
	public void addItem() {
		Item testItem = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		stock.put(testItem);
		assertEquals(0, stock.get(testItem));
	}
	
	//Test 3: Set Quantity.
	@Test
	public void setQuantity() {
		Item testItem = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		stock.put(testItem);
		int newQuantity = 700;
		stock.setAmount(testItem, newQuantity);
		
		assertEquals(newQuantity, stock.get(testItem));
	}
	
	//Test 4: Can't Add Same Item Twice.
	@Test (expected = StockException.class)
	public void duplicateItem() throws StockException {
		Item testItem = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		stock.put(testItem);
		stock.put(testItem);
	}
	
	//Test 5: Can't Have Negative Quantity.
	@Test (expected = StockException.class)
	public void negativeQuantity() throws StockException {
		Item testItem = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		stock.put(testItem);
		
		stock.setAmount(testItem, -5);
	}
	
	//Test 6: Can't Set Quantity for Non-Existent Item.
	@Test (expected = StockException.class) 
	public void unkmownItem() throws StockException {
		Item testItem = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		stock.setAmount(testItem);
	}
	
	//Test 7: Get Item By Name.
	@Test
	public void getItemByName() {
		Item testItem1 = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		Item testItem2 = new Item(0, "Coffee", 2, 3, 200, 225);
		stock.put(testItem1);
		stock.put(testItem2);
		
		assertEquals(testItem1, stock.get("Ice Cream"));
	}
	
	//Test 8: Test Iterator 
	@Test
	public void testIterator() {
		Item testItem1 = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		Item testItem2 = new Item(0, "Coffee", 2, 3, 200, 225);
		Item testItem3 = new Item(0, "Milk", 3, 4, 100, 150, 3);
		
		stock.put(testItem1);
		stock.put(testItem2);
		stock.put(testItem3);
		
		String expectedOutput = "Ice CreamCoffeeMilk";
		String actualOutput = "";
		
	    for (Item i : stock) {
	        actualOutput += i.getName();
	    }
		
		assertEquals(expectedOutput, actualOutput);
	}
}
