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
		stock.add(testItem);
		
		String expectedOutput = "Ice Cream, 3, 4, 300, 400, -20\n";
		assertEquals(expectedOutput, stock.toString());
	}
	
	//Test 3: Remove Item.
	@Test
	public void removeItem() {
		Item testItem1 = new Item("Ice Cream", 3, 4, 300, 400, -20);
		Item testItem2 = new Item("Milk", 3, 4, 100, 150, 3);
		
		stock.add(testItem1);
		stock.add(testItem2);
		stock.remove(testItem1);
		
		String expectedOutput = "Milk, 3, 4, 100, 150, 3\n";
		assertEquals(expectedOutput, stock.toString());
	}
	
}
