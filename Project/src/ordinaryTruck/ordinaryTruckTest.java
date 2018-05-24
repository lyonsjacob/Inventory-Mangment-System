package ordinaryTruck;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import exceptions.DeliveryException;
import exceptions.StockException;
import manifest.ManifestTest;


public class ordinaryTruckTest {
	// Test: Declaring Item objects.
	OrdinaryTruck ordinaryTruck;

	
	
	// Test: add item to truck, item and quantity in hash map.
	//cost price
	@Before @Test
	public void addItemTest() throws DeliveryException {
		ordinaryTruck = new OrdinaryTruck();
		String itemName = "Coffee";
		int quantity = 300;
		
		ordinaryTruck.addItem(itemName, quantity);
	}
	
	
	
	// Test: get the quantity of items held in the truck 
	@Test
	public void getTotalQuantityTest() {
		int quantity = 300;
		assertEquals(quantity, ordinaryTruck.getTotalQuantity());
	}
		
	
	
	// Test: check if quantity is equal 1000
	@Test
	public void getQuantityMaxTest() throws DeliveryException {
		String itemName = "beans";
		int quantity = 700;
		ordinaryTruck.addItem(itemName, quantity);
		
		assertEquals(1000, ordinaryTruck.getTotalQuantity());
	}
	
	
	
	// Test: check if quantity is larger than 1000
	@Test (expected = DeliveryException.class)
	public void overLoadTest() throws DeliveryException {
		String itemName = "beans";
		int quantity = 701;
		ordinaryTruck.addItem(itemName, quantity);
	}
	
	
	//Test: cannot add an item with negative quantity
	@Test(expected = DeliveryException.class)
	public void itemNegativeQuantity() throws DeliveryException {
		String itemName = "peas";
		int quantity = -1;	
		ordinaryTruck.addItem(itemName, quantity);
	}
	
	
	
	
	// Test: get string 
	@Test
	public void toStringTest() throws DeliveryException {
		ordinaryTruck.addItem("milk", 100);
		String itemString = ">Ordinary \n Coffee,300 \n milk,100";
		assertEquals(itemString, ordinaryTruck.convertToString());
	}
	
	
	
	
	// Test: get cost of truck
	@Test
	public void getCostTest() {
	 double cost = 750 + 0.25*300;
	 assertEquals(cost, ordinaryTruck.getCost(),0.01);
	}
	
	// Test: get cost of truck with more than one item
	@Test
	public void getCostMultipleItemTest() throws DeliveryException {
		String itemName = "bread";
		int quantity = 300;
		ordinaryTruck.addItem(itemName, quantity);
		
	 double cost = 750 + 0.25*600;
	 assertEquals(cost, ordinaryTruck.getCost(),0.01);
	}
	


}
