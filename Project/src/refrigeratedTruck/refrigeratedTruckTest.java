package refrigeratedTruck;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class refrigeratedTruckTest {

	// im expecting this to be a bit buggy let me know how you go.
		// Test 1: Declaring Item objects.
		RefrigeratedTruck refrigeratedTruck;

		
		// Test 2: add item to truck
		@Before @Test
		public void addItemToOrdinaryTruckTest() {
			String itemName = "iceream";
			int costPrice = 3;
			int quantity = 300;
			int temperature = -20;
			
			refrigeratedTruck.addItem(itemName, costPrice, quantity, temperature);
		}
		
		// Test 3: get truck temperature
		@Test
		public void getTemperatureTest() {
			int temperature = -20;
			assertEquals(temperature, refrigeratedTruck.getTemperature());
		}
		
		//Test 4: check temperature range
		@Test
		public void tempRangeTest() {
			int temperature = refrigeratedTruck.getTemperature();
			
			if((temperature <-20) | (temperature > 10)) {
				fail("temperature not in range");
			}
		}
		
		
		// Test 5: get hash map where item and cost are stored
		// note later we can implement in iterator to return each item in the map
		// when writing to CSV thoughts? 
		@Test
		public void GetHashMapTest() {	
			Map<String, Integer> itemQuantityMap;// = new HashMap<String, Integer>();
			int quantity = 300;
			itemQuantityMap = refrigeratedTruck.GetHashMap();
			
			assertEquals(quantity, itemQuantityMap.get("iceream"));	
		}
		
		// Test 6: get the quantity of items held in the truck 
		@Test
		public void getTotalQuantityTest() {
			int quantity = 300;
			assertEquals(quantity, refrigeratedTruck.getTotalQuantity());
		}
				
		// Test 7: check if quantity is greater than 800 
		@Test
		public void getQuantityMaxTest() {
			if( refrigeratedTruck.getTotalQuantity() > 800) {
				fail("To many items in truck");
			}
		}
			
		// Test 8: get the total cost of the order including item cost
		@Test
		public void getCostTest() {
			double expectedCost = 8880.266349;
			assertEquals(expectedCost, refrigeratedTruck.getCostTest());
		}
		

	}
