package manifest;

import java.util.ArrayList;
import java.util.Iterator;

import item.Item;
import truck.Truck;

/**
 * A class that holds a number of Trucks.
 * @author Mitchell Willemse
 *
 */
public class Manifest implements Iterable<Truck> {
	
	private double cost;
	private int numOfTrucks;
	private ArrayList<Truck> trucks;
	
	
	
	/**
	 * 
	 */
	public Manifest() {
		trucks = new ArrayList<Truck>();
		cost = 0;
		numOfTrucks = 0;
	}
	
	
	
	/**
	 * 
	 * @param truck
	 */
	public void addTruck(Truck truck) {
		trucks.add(truck);
		numOfTrucks++;
	}
	
	
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Truck getTruck(int index) {
		return trucks.get(index);
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public double getManifestCost() {
		cost = 0;
		
	    for (Truck i : trucks) {
	        cost = cost + i.getcost();
	    }

		return cost;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public int getNumOfTrucks() {
		return numOfTrucks;
	}

	
	
	/**
	 * 
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
