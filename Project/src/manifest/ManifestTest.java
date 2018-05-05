package manifest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ordinaryTruck.OrdinaryTruck;
import stock.Stock;
import truck.Truck;

/**
 * The following tests are for the basic functionality of
 * the Manifest class.
 * 
 * This class is a collection of trucks. It is used to store trucks 
 * containing store order information
 * 
 * @author Jacob Lyons
 *
 */
public class ManifestTest {
	
		//Declaring Manifest object.
		Manifest manifest;

		//Test 1: Constructing an empty Manifest object.
		@Before @Test
		public void ManifestTest() {
			manifest = new Manifest();
		}
		
		//Test 2: Adding a truck to Manifest.
		@Before @Test
		public void addTruckTest() {
			
			String itemName = "Coffee";
			int costPrice = 3;
			int quantity = 300;
			OrdinaryTruck ordinaryTruck = new OrdinaryTruck();
			ordinaryTruck.addItem(itemName, costPrice, quantity);
			addTruck(ordinaryTruck);
			
			// will update the getTruck to iterator method in future.
			assertEquals(ordinaryTruck, getTruck());
		}
		
		//Test 3: Adding cost of truck to Manifest.
		@Test
		public void getManifestCostTest() {
			double cost = ordinaryTruck.getCost();
			assertEquals(cost, getManifestCost()); 	
		}
		
}
