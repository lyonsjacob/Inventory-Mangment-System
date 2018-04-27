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
	Item items;
	
	// Test 1: Constructing an empty Item object.
	@Before @Test
	public void setUpEmptyItem() {
		items = new Item();
	}
	
	//Test 2: Constructing an Item object with values;
	@Test
	public void setUpItem() {
		String name = "Coffee";
		int costPrice = 3;
		int sellPrice = 4;
		int reorderPoint = 300;
		int reorderAmount = 400;
		
		items = new Item(name, costPrice, sellPrice, reorderPoint, reorderAmount);
	}
}
