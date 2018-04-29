package item;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/***
 * The following tests are for the basic functionality of
 * the item class.
 * 
 * @author Mitchell Willemse
 *
 */
public class ItemTest {

	// Test 0: Declaring Item objects.
	Item item;
	
	//Test 1: Constructing an Item object. 
	@Before @Test
	public void setUpItem() {
		String name = "Ice Cream";
		int costPrice = 3;
		int sellPrice = 4;
		int reorderPoint = 300;
		int reorderAmount = 400;
		int temperature = -20;
		
		item = new Item(name, costPrice, sellPrice, reorderPoint, reorderAmount, temperature);
	}
	
	//Test 2: Get Name.
	@Test
	public void getName() {
		String expectedName = "Ice Cream";
		assertEquals(expectedName, item.getName());
	}
	
	//Test 3: Get Cost Price.
	@Test
	public void getCostPrice() {
		int expectedCostPrice = 3;
		assertEquals(expectedCostPrice, item.getCostPrice());
	}
	
	//Test 4: Get Sell Price.
	@Test
	public void getSellPrice() {
		int expectedSellPrice = 4;
		assertEquals(expectedSellPrice, item.getSellPrice());
	}
	
	//Test 5: Get Reorder Point.
	@Test
	public void getReorderPoint() {
		int expectedReorderPoint = 300;
		assertEquals(expectedReorderPoint, item.getReorderPoint());
	}
	
	//Test 6: Get Reorder Amount.
	@Test
	public void getReorderAmount() {
		int expectedReorderAmount = 400;
		assertEquals(expectedReorderAmount, item.getReorderAmount());
	}
	
	//Test 7: Get Temperature.
	@Test
	public void getTemperature() {
		int expectedTemperature = -20;
		assertEquals(expectedTemperature, item.getTemperature());
	}
	
	//Test 8: Item With No Temperature.
	//Not sure how we should best handle this. Do we have a new constructor, 
	//implement optional parameters or just pass temperature as null if there
	//is none?
	@Test
	public void testItemNoTemperature() {
		item = new Item("Coffee", 2, 3, 200, 225, null);
		assertNull(item.getTemperature());
	}
	
	//Test 9: Test To String.
	//This might be useful for when outputting the item for CSV
	@Test
	public void testToString() {
		item = new Item("Milk", 3, 4, 100, 150, 3);
		String expectedOutput = "Milk, 3, 4, 100, 150, 3\n";
		
		assertEquals(expectedOutput, item.toString());
	}
	
	//Test 10: Test To String with No Temperature.
	@Test
	public void testToStringNoTemperature() {
		item = new Item("Coffee", 2, 3, 200, 225, null);
		String expectedOutput = "Coffee, 2, 3, 200, 225\n";
		
		assertEquals(expectedOutput, item.toString());
	}
}
