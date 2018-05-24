package item;

import org.junit.Before;
import org.junit.Test;

import exceptions.StockException;

import static org.junit.Assert.*;

/***
 * The following tests are for the basic functionality of
 * the item class.
 * 
 * @author Mitchell Willemse (n9470620).
 */
public class ItemTest {

	/**
	 * Test 0: Declaring Item objects.
	 */
	Item item;
	
	/**
	 * Test 1: Constructing an Item object. 
	 * @author Mitchell Willemse (n9470620).
	 */
	@Before @Test
	public void setUpItem() {
		//Create variables.
		int amount = 0;
		String name = "Ice Cream";
		double costPrice = 3;
		double sellPrice = 4;
		int reorderPoint = 300;
		int reorderAmount = 400;
		int temperature = -20;
		
		//Create item.
		item = new Item(amount, name, costPrice, sellPrice, reorderPoint, reorderAmount, temperature);
	}
	
	/**
	 * Test 2: Constructing an Item Object without Temperature
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void setUpItemWithoutTemp() {
		//Create variables.
		int amount = 0;
		String name = "Ice Cream";
		double costPrice = 3;
		double sellPrice = 4;
		int reorderPoint = 300;
		int reorderAmount = 400;
		
		//Create item.
		item = new Item(amount, name, costPrice, sellPrice, reorderPoint, reorderAmount);
	}
	
	/**
	 * Test 3: Get Amount.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void getAmount() {
		//Assert amount is 0.
		assertEquals(0, item.getAmount());
	}
	
	/**
	 * Test 4: Set Amount
	 * @throws StockException
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void setAmount() throws StockException {
		//Set amount of item to 400.
		item.setAmount(400);
		
		//Create variables.
		int expectedAmount = 400;
		int actualAmount = item.getAmount();
		
		//Assert they are equal.
		assertEquals(expectedAmount, actualAmount);
	}
	
	/**
	 * Test 5: Needs Reorder
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void needsReorder() {
		//Assert item needs reorder.
		assertTrue(item.isBelowReorderPoint());
	}
	
	/**
	 * Test 6: Get Name.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void getName() {
		//Create variables.
		String expectedName = "Ice Cream";
		String actualname = item.getName();
		
		//Assert they are equal.
		assertEquals(expectedName, actualname);
	}
	
	/**
	 * Test 7: Get Cost Price.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void getCostPrice() {
		//Create variables.
		double expectedCostPrice = 3;
		double actualCostPrice = item.getCostPrice();
		
		//Assert they are equal.
		assertEquals(expectedCostPrice, actualCostPrice, 0.01);
	}
	
	/**
	 * Test 8: Get Sell Price.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void getSellPrice() {
		//Create variables.
		int expectedSellPrice = 4;
		double actualSellPrice = item.getSellPrice();
		
		//Assert they are equal.
		assertEquals(expectedSellPrice, actualSellPrice, 0.01);
	}
	
	/**
	 * Test 9: Get Reorder Point.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void getReorderPoint() {
		//Create variables.
		int expectedReorderPoint = 300;
		int actualReorderPoint = item.getReorderPoint();
		
		//Assert they are equal.
		assertEquals(expectedReorderPoint, actualReorderPoint);
	}
	
	/**
	 * Test 10: Get Reorder Amount.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void getReorderAmount() {
		//Create variables.
		int expectedReorderAmount = 400;
		int actualReorderAmount = item.getReorderAmount();
		
		//Assert they are equal.
		assertEquals(expectedReorderAmount, actualReorderAmount);
	}
	
	/**
	 * Test 11: Get Temperature.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void getTemperature() {
		//Create variables.
		int expectedTemperature = -20;
		int actualTemperature = item.getTemperature();
		
		//Assert they are equal.
		assertEquals(expectedTemperature, actualTemperature);
	}
	
	/**
	 * Test 12: Get Temperature for Item With No Temperature.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void testItemNoTemperature() {
		//Create new item with no temperature.
		item = new Item(0, "Coffee", 2, 3, 200, 225);
		
		//Ensure that when temperature is sought, null is returned,
		//as there is no temperature.
		assertNull(item.getTemperature());
	}
	
	/**
	 * Test 13: Test To String.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void testToString() {
		//Create new item.
		item = new Item(0, "Milk", 3, 4, 100, 150, 3);
		
		//Create variables.
		String expectedOutput = "0, Milk, 3.0, 4.0, 100, 150, 3\n";
		String actualOutput = item.toString();
		
		//Assert they are equal.
		assertEquals(expectedOutput, actualOutput);
	}
	
	/**
	 * Test 14: Test To String with No Temperature.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test
	public void testToStringNoTemperature() {
		//Create new item, no temperature.
		item = new Item(0, "Coffee", 2, 3, 200, 225);
		
		//Create variables.
		String expectedOutput = "0, Coffee, 2.0, 3.0, 200, 225\n";
		String actualOutput = item.toString();
		
		//Assert they are equal.
		assertEquals(expectedOutput, actualOutput);
	}
	
	/**
	 * Test 15: Can't Set negative Amount.
	 * @throws StockException because amount can't be set to negative.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test (expected = StockException.class) 
	public void setNegativeAmount() throws StockException {
		//Attempt to set negative amount.
		item.setAmount(-5);
	}
	
	/**
	 * Test 16. Can't have negative costPrice.
	 * @throws StockException because costPrice can't be negative.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test (expected = StockException.class)
	public void setNegativeCost() throws StockException {
		item = new Item(0, "Test", -5, 0, 0, 0);
	}
	
	/**
	 * Test 17. Can't have negative costPrice.
	 * @throws StockException because sellPrice can't be negative.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test (expected = StockException.class)
	public void setNegativeSell() throws StockException {
		item = new Item(0, "Test", 0, -5, 0, 0);
	}
	
	/**
	 * Test 18. Can't have negative reorderPoint.
	 * @throws StockException because reorderPoint can't be negative.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test (expected = StockException.class)
	public void setNegativeReorderPoint() throws StockException {
		item = new Item(0, "Test", 0, 0, -5, 0);
	}
	
	/**
	 * Test 19. Can't have negative reorderAmount.
	 * @throws StockException because reorderAmount can't be negative.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Test (expected = StockException.class)
	public void setNegativeReorderAmount() throws StockException {
		item = new Item(0, "Test", 0, 0, 0, -5);
	}
}
