package ordinaryTruck;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import manifest.Manifest;


public class ordinaryTruckTest {
	// im expecting this to be a bit buggy let me know how you go.
	// Test 0: Declaring Item objects.
	OrdinaryTruck ordinaryTruck;
	
	//Test 1: Constructing an empty ordinary truck object.
	@Before @Test
	public void Manifest() {
		ordinaryTruck = new OrdinaryTruck();
	}
	
	// Test 1: add item to truck, item and quantity in hash map.
	//cost price added to a running cost total.
	@Before @Test
	public void addItemTest() {
		String itemName = "Coffee";
		int costPrice = 3;
		int quantity = 300;
		
		ordinaryTruck.addItem(itemName, costPrice, quantity);
	}
	
	// Test 2: get hash map where item and cost are stored
	// note later we can implement in iterator to return each item in the map
	// when writing to CSV thoughts? 
	@Test
	public void GetHashMapTest() {	
		Map<String, Integer> itemQuantityMap;// = new HashMap<String, Integer>();
		int quantity = 300;
		itemQuantityMap = ordinaryTruck.GetHashMap();
		
		assertEquals(quantity, itemQuantityMap.get("Coffee"));	
	}
	
	// Test 3: get the quantity of items held in the truck 
	@Test
	public void getTotalQuantityTest() {
		int quantity = 300;
		assertEquals(quantity, ordinaryTruck.getTotalQuantity());
	}
			
	// Test 4: check if quantity is greater than 1000 
	@Test
	public void getQuantityMaxTest() {
		if(ordinaryTruck.getTotalQuantity() > 1000) {
			fail("To many items in truck");
		}
	}
		
	// Test 5: get the total cost of the order including item cost
	@Test
	public void getCostTest() {
		double expectedCost = 3.00*300.00 + 750.00+0.25*300.00;
		assertEquals(expectedCost, ordinaryTruck.getCostTest());
	}
	
	// Need arraylist to be implemented to check if item requires refrigeration

}
