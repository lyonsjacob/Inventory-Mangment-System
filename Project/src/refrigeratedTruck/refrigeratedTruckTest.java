package refrigeratedTruck;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.DeliveryException;

public class refrigeratedTruckTest {


	// Test: Declaring Item objects.
	RefrigeratedTruck refrigeratedTruck;
		
	
	
	
	// Test: add item to truck, item and quantity in hash map.
	@Before @Test
	public void addItemToOrdinaryTruckTest() throws DeliveryException {
		refrigeratedTruck = new RefrigeratedTruck(); 
			
		String itemName = "icecream";
		int quantity = 300;
		int temperature = -20;	
		refrigeratedTruck.addItem(itemName, quantity, temperature);
	}
		
	
	
	
	// Test: add warm item to truck, item and quantity in hash map.
	@Test
	public void addWarmItemToRefrigeratedTruckTest() throws DeliveryException {
		String itemName = "bread";
		int quantity = 300;
		refrigeratedTruck.addItem(itemName, quantity);
	}
	
	
	
	
	//Test: cannot add an item with negative quantity
	@Test(expected = DeliveryException.class)
	public void itemNegativeQuantity() throws DeliveryException {
		String itemName = "ice";
		int quantity = -1;
		int temperature = -20;	
		refrigeratedTruck.addItem(itemName, quantity, temperature);
	}
		    
	
	
	
	// Test: get truck temperature
	@Test
	public void getTemperatureTest() {
		int temperature = -20;
		assertEquals(temperature, refrigeratedTruck.getTemperature());
	}
		
	
	
	
	// Test: check out of bound truck temperature
	@Test (expected = DeliveryException.class)
	public void temperatureToLowTest() throws DeliveryException {
		String itemName = "ice";
		int quantity = 300;
		int temperature = -21;	
		refrigeratedTruck.addItem(itemName, quantity, temperature);
	}
		
	
	
	
	// Test: check to see if truck temperature is replaced with a warmer temperature
	@Test (expected = DeliveryException.class)
	public void incorectTempTest() throws DeliveryException {
		String itemName = "tomatos";
		int quantity = 300;
		int temperature = 10;	
		refrigeratedTruck.addItem(itemName, quantity, temperature);
	}
	
	
	
	
	// Test: get the quantity of items held in the truck 
	@Test
	public void getTotalQuantityTest() throws DeliveryException {
		String itemName = "beans";
		int quantity = 100;
		refrigeratedTruck.addItem(itemName, quantity);
		
		String itemName1 = "milk";
		int quantity1 = 100;
		refrigeratedTruck.addItem(itemName1, quantity1);
		
		int expectedQuantity = 500;
		assertEquals(expectedQuantity, refrigeratedTruck.getTotalQuantity());
	}
		
	
	
	
	// Test: check if quantity is equal 800
	@Test
	public void getQuantityMaxTest() throws DeliveryException {
		String itemName = "beans";
		int quantity = 500;
		refrigeratedTruck.addItem(itemName, quantity);
		
		assertEquals(800, refrigeratedTruck.getTotalQuantity());
	}
	
	
	
	// Test: check if quantity is larger than 800
	@Test (expected = DeliveryException.class)
	public void overLoadTest() throws DeliveryException {
		String itemName = "beans";
		int quantity = 501;
		refrigeratedTruck.addItem(itemName, quantity);
	}
	
	
	
	
	// Test: print item list string
	@Test
	public void toStringTest() throws DeliveryException {
			
		refrigeratedTruck.addItem("milk", 100);
		String itemString = ">Refrigerated\nicecream,300\nmilk,100\n";
		assertEquals(itemString, refrigeratedTruck.convertToString());
	}
		
	
	
	
	// Test: get truck cost
	@Test
	public void getcostTest() throws DeliveryException {
		String itemName = "beans";
		int quantity = 100;
		refrigeratedTruck.addItem(itemName, quantity);
		
		String itemName1 = "milk";
		int quantity1 = 100;
		refrigeratedTruck.addItem(itemName1, quantity1);
		
		double cost = 900 + 200.00*Math.pow(0.70,-20.00/5.00);	
		assertEquals(cost, refrigeratedTruck.getCost(),0.001);
	}
	
	
	
	

}
