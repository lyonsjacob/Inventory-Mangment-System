package manifest;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import exceptions.DeliveryException;
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

		
		
		//Adding a truck to Manifest.
		@Before
		public void addTruck() throws DeliveryException {
			manifest = new Manifest();
			String itemName = "Coffee";
			int quantity = 300;
			OrdinaryTruck ordinaryTruck = new OrdinaryTruck();
			ordinaryTruck.addItem(itemName, quantity);
			manifest.addTruck(ordinaryTruck);
		}
		
		
		
		
		/*Test: Iterator and if truck has been added to manifest.
		 * by using the trucks convertToString method to get 
		 * the details of the truck.
		 */
		@Test
		public void addTruckTest() throws DeliveryException {
			Iterator<Truck> manifestIterator = manifest.iterator();
			 
			String truckDetails ="";
		    while(manifestIterator.hasNext()) {
		      truckDetails = manifestIterator.getTruckString();
		      manifestIterator.next();  
		    }
		    
		    String itemString = ">Ordinary Truck \n Coffee, 300";
			assertEquals(itemString, truckDetails);
		}
		
		
		// clear manifest and check if manifest is empty.
		@Test
		public void clearManifestTest() {
			manifest.clearManifest();
			Iterator<Truck> manifestIterator = manifest.iterator();
			assertEquals(false, manifestIterator.hasNext());
		}
		
}
