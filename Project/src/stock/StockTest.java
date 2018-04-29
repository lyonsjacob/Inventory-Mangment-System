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
	
	// Test 0: Declaring Stock object.
	Stock stock;

	// Test 1: Constructing an empty Stock object.
	@Before @Test
	public void setUpStock() {
		stock = new Stock();
	}
	
	//Test 2: Add Item.
	@Test
	public void addItem() {
		Item testItem = new Item("Ice Cream", 3, 4, 300, 400, -20);
		stock.add(testItem);
		
		int expectedCount = 1;
		assertEquals(expectedCount, stock.getCount());
	}
	
	//Test 3: 

}
