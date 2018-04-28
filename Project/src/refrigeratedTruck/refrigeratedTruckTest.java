package refrigeratedTruck;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class refrigeratedTruckTest {

	// im expecting this to be a bit buggy let me know how you go.
		// Test 0: Declaring Item objects.
		RefrigeratedTruck refrigeratedTruck;
		
		// Test 1: Constructing an empty Item object.
		@Before @Test
		public void setUpEmptyTruckTest() {
			refrigeratedTruck = new RefrigeratedTruck();
		}
		
		// Test 3: add item to truck
		@Before @Test
		public void addItemToOrdinaryTruckTest() {
			String itemName = "iceream";
			int costPrice = 3;
			int quantity = 300;
			int temperature = -20;
			
			refrigeratedTruck.addItem(itemName, costPrice, quantity, temperature);
		}
		
		// Test 4: get truck temperature
		@Test
		public void getTemperatureTest() {
			int temperature = -20;
			
			assertEquals(temperature, refrigeratedTruck.getTemperature());
		}
		
		
		// Test 5: get hash map where item and cost are stored
		// note later we can implement in iterator to return each item in the map
		// when writing to CSV thoughts? 
		@Test
		public void GetHashMapTest() {	
			Map<String, Integer> itemQuantityMap;// = new HashMap<String, Integer>();
			int quantity = 300;
			itemQuantityMap = refrigeratedTruck.GetHashMap();
			
			assertEquals(quatity, itemQuantityMap.get("iceream"));	
		}
		
		// Test 5: get the quantity of items held in the truck 
		@Test
		public void getTotalQuantityTest() {
			int quantity = 300;
			assertEquals(quatity, refrigeratedTruck.getTotalQuantity());
		}
				
		// Test 6: check if quantity is greater than 800 
		@Test
		public void getQuantityMaxTest() {
			if( refrigeratedTruck.getTotalQuantity() > 800) {
				fail("To many items in truck");
			}
		}
			
		// Test 7: get the total cost of the order including item cost
		@Test
		public void getCostTest() {
			double expectedCost = 3.00*300.00 + 900.00+0.7;
			assertEquals(quatity, refrigeratedTruck.getCostTest());
		}
		
		// Need arraylist to be implemented to check if item requires refrigeration

	}
