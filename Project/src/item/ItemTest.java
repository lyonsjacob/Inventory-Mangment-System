package item;

import org.junit.Before;
import org.junit.Test;

import exceptions.StockException;

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
		int amount = 0;
		String name = "Ice Cream";
		double costPrice = 3;
		double sellPrice = 4;
		int reorderPoint = 300;
		int reorderAmount = 400;
		int temperature = -20;
		
		
		item = new Item(amount, name, costPrice, sellPrice, reorderPoint, reorderAmount, temperature);
	}
	
	//Test 2: Constructing an Item Object without Temperature
	@Test
	public void setUpItemWithoutTemp() {
		int amount = 0;
		String name = "Ice Cream";
		double costPrice = 3;
		double sellPrice = 4;
		int reorderPoint = 300;
		int reorderAmount = 400;
		
		
		item = new Item(amount, name, costPrice, sellPrice, reorderPoint, reorderAmount);
	}
	
	//Test 3: Get Amount.
	@Test
	public void getAmount() {
		assertEquals(0, item.getAmount());
	}
	
	//Test 4: Set Amount
	@Test
	public void setAmount() {
		int newAmount = 400;
		item.setAmount(400);
		
		assertEquals(newAmount, item.getAmount());
	}
	
	//Test 5: Can't Set Negative Amount
	@Test (expected = StockException.class) 
	public void setNegativeAmount() {
		item.setAmount(-5);
	}
	
	//Test 6: Needs Reorder
	@Test
	public void needsReorder() {
		assertEquals(false, item.isBelowReorderPoint());
	}
	
	//Test 7: Get Name.
	@Test
	public void getName() {
		String expectedName = "Ice Cream";
		assertEquals(expectedName, item.getName());
	}
	
	//Test 8: Get Cost Price.
	@Test
	public void getCostPrice() {
		int expectedCostPrice = 3;
		assertEquals(expectedCostPrice, item.getCostPrice());
	}
	
	//Test 9: Get Sell Price.
	@Test
	public void getSellPrice() {
		int expectedSellPrice = 4;
		assertEquals(expectedSellPrice, item.getSellPrice());
	}
	
	//Test 10: Get Reorder Point.
	@Test
	public void getReorderPoint() {
		int expectedReorderPoint = 300;
		assertEquals(expectedReorderPoint, item.getReorderPoint());
	}
	
	//Test 11: Get Reorder Amount.
	@Test
	public void getReorderAmount() {
		int expectedReorderAmount = 400;
		assertEquals(expectedReorderAmount, item.getReorderAmount());
	}
	
	//Test 12: Get Temperature.
	@Test
	public void getTemperature() {
		Integer expectedTemperature = -20;
		assertEquals(expectedTemperature, item.getTemperature());
	}
	
	//Test 13: Get Temperature for Item With No Temperature.
	@Test
	public void testItemNoTemperature() {
		item = new Item(0, "Coffee", 2, 3, 200, 225);
		assertNull(item.getTemperature());
	}
	
	//Test 13: Test To String.
	//This might be useful for when outputting the item for CSV
	@Test
	public void testToString() {
		item = new Item(0, "Milk", 3, 4, 100, 150, 3);
		String expectedOutput = "0, Milk, 3, 4, 100, 150, 3\n";
		
		assertEquals(expectedOutput, item.toString());
	}
	
	//Test 14: Test To String with No Temperature.
	@Test
	public void testToStringNoTemperature() {
		item = new Item(0, "Coffee", 2, 3, 200, 225, null);
		String expectedOutput = "0, Coffee, 2, 3, 200, 225\n";
		
		assertEquals(expectedOutput, item.toString());
	}
}
