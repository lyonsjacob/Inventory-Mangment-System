 package stock;

import item.Item;
import exceptions.StockException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/***
 * The following tests are for the basic functionality of
 * the Stock class.
 * 
 * @author Mitchell Willemse (n9470620).
 */
public class StockTest {
	
	/**
	 * Test 0: Declaring Stock object.
	 * @author Mitchell Willemse (n9470620).
	 */
	Stock stock;

	/**
	 * Test 1: Constructing an empty Stock object.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Before @Test
	public void setUpStock() {
		stock = new Stock();
	}
	
	/**
	 * Test 2: Add Item. Adds Item to the Stock object and uses the get() method
	 * to ensure the Item was added correctly. 
	 * @throws StockException 
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void addItem() throws StockException {
		//Create item.
		Item testItem = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		
		//Add it to inventory.
		stock.put(testItem);
		
		//Get item by name to ensure it is stored in inventory.
		assertEquals(testItem, stock.getItemName("Ice Cream"));
	}
		
	/**
	 * Test 3: Clear inventory.
	 * @throws StockException 
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test 
	public void clearInventory() throws StockException {
		//Create items and add them to inventory.
		Item testItem1= new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		Item testItem2 = new Item(7, "Chips", 3, 4, 300, 400);
		stock.put(testItem1);
		stock.put(testItem2);
		
		//Clear the inventory.
		stock.clear();
		
		//Assert inventory total is 0.
		assertEquals(0, stock.getStockQuantity());
	}
	
	/*
	 * Test 5: Get Stock Quantity. use getStockQuantity() to get the number of Items stored
	 * in the Stock object.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void getStockQuantity() throws StockException {
		//Create items and add them to inventory.
		Item testItem1 = new Item(3, "Ice Cream", 3, 4, 300, 400, -20);
		Item testItem2 = new Item(4, "Tofu", 3, 4, 300, 400, 3);
		Item testItem3 = new Item(7, "Chips", 3, 4, 300, 400);
		
		stock.put(testItem1);
		stock.put(testItem2);
		stock.put(testItem3);
		
		//Create variables.
		int expectedOutput = 3;
		int actualOutput = stock.getStockQuantity();
		
		//Assert.
		assertEquals(expectedOutput, actualOutput);
	}
	
	/*
	 * Test 6: Test Iterator. Tests to make sure the Stock class can be used to iterate
	 * through each Item in the Stock object. Ensures each Item is properly iterated through.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void testIterator() throws StockException {
		//Create items and add them to inventory.
		Item testItem1 = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		Item testItem2 = new Item(0, "Coffee", 2, 3, 200, 225);
		Item testItem3 = new Item(0, "Milk", 3, 4, 100, 150, 3);
		
		stock.put(testItem1);
		stock.put(testItem2);
		stock.put(testItem3);
		
		//Create variables.
		String expectedOutput = "Ice CreamCoffeeMilk";
		String actualOutput = "";
		
		//Iterate through inventory.
	    for (Item i : stock) {
	        actualOutput += i.getName();
	    }
		
	    //Assert.
		assertEquals(expectedOutput, actualOutput);
	}
}
