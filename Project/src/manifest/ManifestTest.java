package manifest;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import exceptions.DeliveryException;
import ordinaryTruck.OrdinaryTruck;
import refrigeratedTruck.RefrigeratedTruck;
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

		
		
		//Adding an truck to Manifest.
		@Before
		public void addTruck() throws DeliveryException {
			manifest = new Manifest();
			String itemName = "Coffee";
			int quantity = 300;
			OrdinaryTruck ordinaryTruck = new OrdinaryTruck();
			ordinaryTruck.addItem(itemName, quantity);
			manifest.addTruck(ordinaryTruck);
			
			String itemName2 = "milk";
			int quantity2 = 400;
			int temp = 2;
			RefrigeratedTruck ReffTruck = new RefrigeratedTruck();
			ReffTruck.addItem(itemName2, quantity2, temp);
			manifest.addTruck(ReffTruck);		
		}
		
		
		/*Test: Iterator and if truck has been added to manifest.
		 * by using the trucks convertToString method to get 
		 * the details of the truck.
		 */
		@Test
		public void addTruckTest() throws DeliveryException {
			
			String truckDetails ="";
		    for(Truck i : manifest) {
		      truckDetails = i.convertToString(); 
		    }
		    
		    String itemString = ">Ordinary\nCoffee,300\n>Refrigerated\nmilk,400\n";
			assertEquals(itemString, truckDetails);
		}
		
}
