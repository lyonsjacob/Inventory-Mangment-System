package refrigeratedTruck;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ordinaryTruck.OrdinaryTruck;

public class refrigeratedTruckTest {

	// im expecting this to be a bit buggy let me know how you go.
		// Test 0: Declaring Item objects.
		RefrigeratedTruck refrigeratedTruck;

		//Test 1: Constructing an empty refrigerated truck object.
		@Before @Test
		public void refrigeratedTruck() {
			refrigeratedTruck = new RefrigeratedTruck();
		}
		
		// Test 2: add item to truck, item and quantity in hash map.
		@Before @Test
		public void addItemToOrdinaryTruckTest() {
			String itemName = "iceream";
			int quantity = 300;
			int temperature = -20;
			
			refrigeratedTruck.addItem(itemName, quantity, temperature);
		}
		
		// Test 2: add warm item to truck, item and quantity in hash map.
	    @Test
		public void addWarmItemToRefrigeratedTruckTest() {
			String itemName = "bread";
			int quantity = 300;
			int temperature = -20;	
			refrigeratedTruck.addItem(itemName, quantity);
				}
	    
	    
	    @Test
		public void addWarmItemToRefrigeratedTruckTest() {
			String itemName = "bread";
			int quantity = 300;
			int temperature = -20;	
			refrigeratedTruck.addItem(itemName, quantity);
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
		
		public void toStringTest() {
			
			refrigeratedTruck.addItem("milk", 100);
			String itemString = ">Ordinary Truck \n icecream, 300 \n milk, 100";
			assertEquals(itemString, refrigeratedTruck.toString());
		}
		
		// Test 3: get truck cost
		@Test
		public void getcostTest() {
			double cost = 900 + 200.00*Math.pow(0.70,-20.00/5.00);	
			assertEquals(cost, refrigeratedTruck.getcost());
		}

	}
