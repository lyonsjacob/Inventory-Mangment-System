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
	
	/**
	 * Test 0: Declaring Stock object.
	 */
	Stock stock;

	
	
	/**
	 * Test 1: Constructing an empty Stock object.
	 */
	@Before @Test
	public void setUpStock() {
		stock = new Stock();
	}
	
	
	
	/**
	 * Test 2: Add Item. Adds Item to the Stock object and uses the get() method
	 * to ensure the Item was added correctly. 
	 * @throws StockException 
	 */
	@Test
	public void addItem() throws StockException {
		Item testItem = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		stock.put(testItem);
		
		assertEquals(testItem, stock.get("Ice Cream"));
	}
	
	
	
	/**
	 * Test 3: Set Quantity. Uses the setQuantity() method to change the 'Amount' in the
	 * Item object.
	 * 
	 * I'm keeping setQuantity and getQuantity because although these methods exist
	 * in the Item class and we could just use the Stock.Get method to change them, it
	 * seems a lot more neater to encapsulate them within the stock class.
	 * @throws StockException 
	 */
	@Test
	public void setQuantity() throws StockException {
		Item testItem = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		stock.put(testItem);
		
		int newQuantity = 700;
		stock.setQuantity("Ice Cream", newQuantity);
		
		assertEquals(newQuantity, stock.getQuantity("Ice Cream"));
	}
	
	
	
	/**
	 * Test 4: Can't Add Same Item Twice. Tries to add the same Item twice and receives
	 * StockException.
	 */
	@Test (expected = StockException.class)
	public void duplicateItem() throws StockException {
		Item testItem = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		stock.put(testItem);
		stock.put(testItem);
	}
	
	
	
	/*
	 * Test 5: Can't Have Negative Quantity. Tries to use setQuantity() to set a negative
	 * 'Amount' Receives StockException.
	 */
	@Test (expected = StockException.class)
	public void negativeQuantity() throws StockException {
		Item testItem = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		stock.put(testItem);
		
		stock.setQuantity("Ice Cream", -5);
	}
	
	
	
	/*
	 * Test 6: Can't Set Quantity for Non-Existent Item. Tries to use setQuantity() for an
	 * Item that has not been added to Stock. StockException() is thrown.
	 */
	@Test (expected = StockException.class) 
	public void unkmownItem() throws StockException {
		stock.setQuantity("Cookies", 5);
	}
	
	
	
	/*
	 * Test 7: Get Stock Quantity. use getStockQuantity() to get the number of Items stored
	 * in the Stock object.
	 */
	@Test
	public void getStockQuantity() throws StockException {
		Item testItem1 = new Item(3, "Ice Cream", 3, 4, 300, 400, -20);
		Item testItem2 = new Item(4, "Tofu", 3, 4, 300, 400, 3);
		Item testItem3 = new Item(7, "Chips", 3, 4, 300, 400);
		
		stock.put(testItem1);
		stock.put(testItem2);
		stock.put(testItem3);
		
		int expectedOutput = 3;
		int actualOutput = stock.getStockQuantity();
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	
	// Test if items in stock are sorted by temp
	@Test
	public void sortTest() throws StockException {
		Item testItem0 = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		Item testItem1 = new Item(0, "bread", 3, 4, 300, 400, 10);
		Item testItem2 = new Item(0, "milk", 3, 4, 300, 400, 4);
		Item testItem3  = new Item(0, "weat", 3, 4, 300, 400);
		stock.put(testItem0);
		stock.put(testItem1);
		stock.put(testItem2);
		stock.put(testItem3);
		
		int lastTemp = -100;
		 for (Item i : stock) {
			 
		       if( i.getTemperature() > lastTemp) {
		    	  fail("array not sorted");
		       }
		       lastTemp = i.getTemperature();
		    }
		
		
		
	}
	
	
	
	
	/*
	 * Test 8: Test Iterator. Tests to make sure the Stock class can be used to iterate
	 * through each Item in the Stock object. Ensures each Item is properly iterated through.
	 */
	@Test
	public void testIterator() throws StockException {
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
