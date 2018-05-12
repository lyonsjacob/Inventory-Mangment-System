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
	 * Test 3: Test Initial Capital.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void initialCaptial() {
		//Initial Capital is $100,000 as per spec sheet.
		double expectedinitialCapital = 100000.0;
		store.setCapital(100000);
		
		assertEquals(expectedinitialCapital, store.getCapital(), 1);
	}
	
	/*
	 * Test 4: Set Capital.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void setCapital() {
		double capital = store.getCapital();
		capital = capital - 299.99;
		store.setCapital(capital);
		double expectedCapital = 99700.01;
		
		assertEquals(expectedCapital, store.getCapital(), 1);
	}
	
	/**
	 * Test 5: Test Empty Name.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void emptyName() {
		String expectedName = "Store";
		assertEquals("No store name has been set yet.", expectedName, store.getName());
	}
	
	/*
	 * Test 6: Set Store Name.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void setName() {
		String name = "CAB302 Store!";
		store.setName(name);
		assertEquals(name, store.getName());
	}
	
	/**
	 * Test 7: Get and Set Inventory.
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
		
		int expectedAmount = 1;
		
		assertEquals("Should be one item in the inventory now.", expectedAmount, store.getAmount());
	}
}
