package item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/***
 * The following tests are for the basic functionality of
 * the item class.
 * 
 * @author mitchellwillemse
 *
 */
public class ItemTest {

	// Test 0: Declaring Item objects.
	Item item;
	
	//Test 1: Constructing an Item object.
	@Before @Test
	public void setUpItem() {
		String name = "Ice Cream";
		double costPrice = 3;
		double sellPrice = 4;
		int reorderPoint = 300;
		int reorderAmount = 400;
		double temperature = -20;
		
		item = new Item(name, costPrice, sellPrice, reorderPoint, reorderAmount, temperature);
	}
	
	//Test 2: Get Name
	@Test
	public void getName() {
		String expectedName = "Ice Cream";
		assertEquals(expectedName, item.getName());
	}
	
	//Test 3: Get Cost Price
	@Test
	public void getCostPrice() {
		double expectedCostPrice = 3;
		assertEquals(expectedCostPrice, item.getCostPrice());
	}
	
	//Test 4: Get Sell Price
	@Test
	public void getSellPrice() {
		double expectedSellPrice = 4;
		assertEquals(expectedSellPrice, item.getSellPrice());
	}
	
	//Test 5: Get Reorder Point
	@Test
	public void getReorderPoint() {
		int expectedReorderPoint = 300;
		assertEquals(expectedReorderPoint, item.getReorderPoint);
	}
	
	//Test 6: Get Reorder Amount
	@Test
	public void getReorderAmount() {
		int expectedReorderAmount = 400;
		assertEquals(expectedReorderAmount, item.getReorderAmount);
	}
	
	//Test 7: Get Temperature
	@Test
	public void getTemperature() {
		double expectedTemperature = -20;
		assertEquals(expectedTemperature, item.getTemperature);
	}
}
