package manifest;

import java.util.ArrayList;
import java.util.Iterator;
import truck.Truck;

/**
 * A collection of trucks.
 * @author Mitchell Willemse (n9470620).
 *
 */
public class Manifest implements Iterable<Truck> {
	
	private ArrayList<Truck> trucks;
	
	/**
	 * Constructor that initializes the variables.
	 * @author Mitchell Willemse (n9470620).
	 */
	public Manifest() {
		trucks = new ArrayList<Truck>();
	}
	
	
	
	/**
	 * Adds a truck to the manifest.
	 * @param truck The truck to be added to the manifest.
	 * @author Mitchell Willemse (n9470620).
	 */
	public void addTruck(Truck truck) {
		trucks.add(truck);
	}
	
	
	
	/**
	 * Prints the Manifest of trucks and their items in a CSV format.
	 * @return The list of items and the truck holding them, separated by commas.
	 * @author Mitchell Willemse (n9470620).
	 */
	public String getTruckString() {
		//String to return.
		String output = "";
		
		//Iterate through each truck.
	    for (Truck i : trucks) {
	    		output += i.convertToString();
	    }
	    
	    //Return this string.
		return output;
	}
	
	

	/**
	 * Returns an iterator over elements of type Truck.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Override
	public Iterator<Truck> iterator() {
		return new Iterator<Truck>() {

			private int currentIndex = 0;
			
			@Override
			public boolean hasNext() {
				return currentIndex < trucks.size() && trucks.get(currentIndex) != null;
			}

			@Override
			public Truck next() {
				return trucks.get(currentIndex++);
			}
			
		};
	}

}
