package ordinaryTruck;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ordinaryTruck {
	
	// Test 0: Declaring Item objects.
	OrdinaryTruck ordinaryTruck;
	
	// Test 1: Constructing an empty Item object.
	@Before @Test
	public void setUpEmptyTruckTest() {
		ordinaryTruck = new OrdinaryTruck();
	}
	
	// Test 3: add item to truck
	@Before @Test
	public void addItemToOrdinaryTruckTest() {
		String itemName = "Coffee";
		int costPrice = 3;
		int quantity = 300;
		
		addItemToOrdinaryTruck(itemName, costPrice, quantity);
	}
	
	// Test 4: get the quantity of items held in the truck 
	@Test
	public void getQuantityTest() {
		int quantity = 300;
		assertEquals(quatity, ordinaryTruck.getQuantity());
	}
			
	// Test 5: check if quantity is greater than 1000 
	@Test
	public void getQuantityMaxTest() {
		if( ordinaryTruck.getQuantity() > 1000) {
			fail("To many items in truck");
		}
	}
		
	// Test 6: get the total cost of the order including item cost
	@Test
	public void getCostTest() {
		double expectedCost = 3.00*300.00 + 750.00+0.25*300.00;
		assertEquals(quatity, ordinaryTruck.getCostTest());
	}
	
	// Need arraylist to be implemented to check if item requires refrigeration

}
