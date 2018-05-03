package store;

import item.Item;
import stock.Stock;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * An object for representing the store itself.
 * 
 * The following tests are designed for the Store class, which will
 * be based on the Singleton pattern.
 * 
 * @author Mitchell Willemse
 */
public class StoreTest {
	
	// Test 0: Declaring Store object.
	Store store;
	
	//Test 1: Test Store Instance. Constructor should be protected 
	//instead of public to suppress unauthorized calls to it. getInstance()
	//is used to provide access to the object.
	@Before @Test
	public void storeInstance() {
		store = Store.getInstance();
	}
	
	//Test 2: Test Only One Instance of Store Can Exist.
	@Test
	public void storeSingleInstance() {
		Store s1 = Store.getInstance();
		Store s2 = Store.getInstance();
		
		
		assertEquals("Both Store Objects are Same", s1, s2);
	}
	
	//Test 3: Test Initial Capital.
	@Test
	public void initialCaptial() {
		//Initial Capital is $100,000 as per spec sheet.
		double expectedinitialCapital = 100000.00;
		
		assertSame(expectedinitialCapital, store.getCapital());
	}
	
	//Test 4: Set Capital.
	@Test
	public void setCapital() {
		double capital = store.getCapital();
		capital = capital - 299.99;
		store.setCapital(capital);
		double expectedCapital = 99700.01;
		
		assertSame(expectedCapital, store.getCapital());
	}
	
	//Test 5: Test Empty Name.
	@Test
	public void emptyName() {
		String expectedName = "Store";
		assertEquals("No store name has been set yet.", expectedName, store.getName());
	}
	
	//Test 6: Set Store Name.
	@Test
	public void setName() {
		String name = "CAB302 Store!";
		store.setName(name);
		assertEquals(name, store.getName());
	}
	
	//Test 7: Get and Set Inventory.
	@Test
	public void setInventory() {
		//Get Empty Inventory (a Stock object) from Store.
		Stock inventory = store.getInventory();
		
		//Create Test Item to Add to inventory.
		Item testItem = new Item(0, "Ice Cream", 3, 4, 300, 400, -20);
		inventory.addItem(testItem);
		
		//Set This Back to the Store's Inventory.
		store.setInventory(inventory);
		
		int expectedAmount = 1;
		
		assertEquals("Should be one item in the inventory now.", expectedAmount, store.getAmount());
	}
}
