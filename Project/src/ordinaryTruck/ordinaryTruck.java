package ordinaryTruck;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;


public class ordinaryTruck {
	// im expecting this to be a bit buggy let me know how you go.
	// Test 0: Declaring Item objects.
	OrdinaryTruck ordinaryTruck;
	
	// Test 1: Constructing an empty Item object.
	@Before @Test
	public void setUpEmptyTruckTest() {
		ordinaryTruck = new OrdinaryTruck();
	}
	
	// Test 3: add item to truck
	@Before @Test
	public void addItemTest() {
		String itemName = "Coffee";
		int costPrice = 3;
		int quantity = 300;
		
		ordinaryTruck.addItem(itemName, costPrice, quantity);
	}
	
	// Test 4: get hash map where item and cost are stored
	// note later we can implement in iterator to return each item in the map
	// when writing to CSV thoughts? 
	@Test
	public void GetHashMapTest() {	
		Map<String, Integer> itemQuantityMap;// = new HashMap<String, Integer>();
		int quantity = 300;
		itemQuantityMap = ordinaryTruck.GetHashMap();
		
		assertEquals(quatity, itemQuantityMap.get("Coffee"));	
	}
	
	// Test 5: get the quantity of items held in the truck 
	@Test
	public void getTotalQuantityTest() {
		int quantity = 300;
		assertEquals(quatity, ordinaryTruck.getTotalQuantity());
	}
			
	// Test 6: check if quantity is greater than 1000 
	@Test
	public void getQuantityMaxTest() {
		if( ordinaryTruck.getTotalQuantity() > 1000) {
			fail("To many items in truck");
		}
	}
		
	// Test 7: get the total cost of the order including item cost
	@Test
	public void getCostTest() {
		double expectedCost = 3.00*300.00 + 750.00+0.25*300.00;
		assertEquals(quatity, ordinaryTruck.getCostTest());
	}
	
	// Need arraylist to be implemented to check if item requires refrigeration

}
