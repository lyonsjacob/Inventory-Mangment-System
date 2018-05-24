package store;

import item.Item;

import org.junit.Before;
import org.junit.Test;

import exceptions.StockException;

import static org.junit.Assert.*;

/**
 * The following tests are designed for the Store class, which will
 * be based on the Singleton pattern.
 * 
 * @author Mitchell Willemse (n9470620).
 */

public class StoreTest {
	
	
	/**
	 *  Test 0: Declaring Store object.
	 */
	Store store;
	
	/**
	 * Test 1: Test Store Instance. Constructor should be protected 
	 * instead of public to suppress unauthorized calls to it. getInstance()
	 * is used to provide access to the object.
	 * @author Mitchell Willemse (n9470620).
	*/
	@Before @Test
	public void storeInstance() {
		store = Store.getInstance();
	}
	
	/*
	 * Test 2: Test Only One Instance of Store Can Exist.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void storeSingleInstance() {
		Store s1 = Store.getInstance();
		Store s2 = Store.getInstance();
		
		//Assert both instances are the same.
		assertEquals("Both Store Objects are Same", s1, s2);
	}
	
	/*
	 * Test 3: Set Capital.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void setCapital() {
		//Set capital of store.
		store.setCapital(99700.01);
		
		//Set variables.
		double expectedCapital = 99700.01;
		double actualCapital = store.getCapital();
		
		//Assert.
		assertEquals(expectedCapital, actualCapital, 0.01);
	}
	
	/*
	 * Test 4: Set Store Name.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void setName() {
		//Set store name.
		store.setName("CAB302 Store!");
		
		//Create Variables
		String expectedName = "CAB302 Store!";
		String actualName = store.getName();
		
		//Assert
		assertEquals(expectedName, actualName);
	}
	
	/**
	 * Test 5: Get Inventory.
	 * @throws StockException
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void getInventory() throws StockException {
		//Create Test Item to add to inventory.
		Item testItem = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		store.getInventory().put(testItem);
		
		//Get Values
		int expectedAmount = 1;
		int actualAmount = store.getInventory().getStockQuantity();
		
		//Assert.
		assertEquals("Should be one item in the inventory now.", expectedAmount, actualAmount);
	}
	
	/**
	 * Test 6: Get Capital in Dollar Format.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void getCapitalDollars() {
		//Set store capital.
		store.setCapital(12345.67);
		
		//Get Values.
		String expectedOutput = "$12,345.67";
		String actualOutput = store.getCapitalDolarFormat();
		
		//Assert.
		assertEquals(expectedOutput, actualOutput);
	}
}
