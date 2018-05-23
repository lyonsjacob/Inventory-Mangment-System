package store;

import item.Item;
import stock.Stock;

import org.junit.Before;
import org.junit.Test;

import exceptions.StockException;

import static org.junit.Assert.*;

/**
 * An object for representing the store itself.
 * 
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
		
		assertEquals("Both Store Objects are Same", s1, s2);
	}
	
	/*
	 * Test 3: Set Capital.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void setCapital() {
		double capital = 99700.01;
		store.setCapital(capital);
		
		double expectedCapital = 99700.01;
		double actualCapital = store.getCapital();
		
		assertEquals(expectedCapital, actualCapital, 0.01);
	}
	
	/**
	 * Test 4: Test Empty Name.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void emptyName() {
		String expectedName = "Store";
		assertEquals("No store name has been set yet.", expectedName, store.getName());
	}
	
	/*
	 * Test 5: Set Store Name.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void setName() {
		String name = "CAB302 Store!";
		store.setName(name);
		assertEquals(name, store.getName());
	}
	
	/**
	 * Test 6: Get and Set Inventory.
	 * @throws StockException
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void setInventory() throws StockException {
		//Get Empty Inventory (a Stock object) from Store.
		Stock inventory = store.getInventory();
		
		//Create Test Item to Add to inventory.
		Item testItem = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		inventory.put(testItem);
		
		//Set This Back to the Store's Inventory.
		store.setInventory(inventory);
		
		//Get Values
		int expectedAmount = 1;
		int actualAmount = store.getAmount();
		
		assertEquals("Should be one item in the inventory now.", expectedAmount, actualAmount);
	}
	
	/**
	 * Test 7: Get Capital in Dollar Format.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void getCapitalDollars() {
		//Set store capital
		store.setCapital(12345.67);
		
		//Get Values
		String expectedOutput = "$12,345.67";
		String actualOutput = store.getCapitalDolarFormat();
		
		//Assert
		assertEquals(expectedOutput, actualOutput);
	}
}
