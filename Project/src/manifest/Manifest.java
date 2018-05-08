package manifest;

import java.util.ArrayList;
import java.util.Iterator;

import truck.Truck;

/**
 * A collection of trucks.
 * @author Mitchell Willemse
 *
 */
public class Manifest implements Iterable<Truck> {
	
	private double cost;
	private int numOfTrucks;
	private ArrayList<Truck> trucks;
	
	
	
	/**
	 * Constructor that initializes the variables.
	 */
	public Manifest() {
		trucks = new ArrayList<Truck>();
		cost = 0;
		numOfTrucks = 0;
	}
	
	
	
	/**
	 * Adds a truck to the manifest.
	 * @param truck The truck to be added to the manifest.
	 */
	public void addTruck(Truck truck) {
		trucks.add(truck);
		numOfTrucks++;
	}
	
	
	
	/**
	 * Gets a truck at a certain index, starting at 0.
	 * @param index The index at which to get the truck.
	 * @return The truck at that index.
	 */
	public Truck getTruck(int index) {
		return trucks.get(index);
	}
	
	
	
	/**
	 * Sums the cost of all the trucks within the manifest.
	 * @return The total cost of all the trucks in dollars.
	 */
	public double getManifestCost() {
		cost = 0;
		
	    for (Truck i : trucks) {
	        cost = cost + i.getCost();
	    }

		return cost;
	}
	
	
	
	/**
	 * Get the number of trucks within the manifest.
	 * @return The number of trucks.
	 */
	public int getNumOfTrucks() {
		return numOfTrucks;
	}
	
	

	/**
	 * Returns an iterator over elements of type Truck.
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
