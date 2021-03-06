package readInCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.CSVFormatException;
import exceptions.StockException;
import item.Item;
import store.Store;

/**
 * This class reads in a manifest CSV and updates the items quantity in stock and reduces the capital.
 * If an exception occurs during the item update process the changes to the stores stock
 *  will be undone before it throws a message to the user.
 * @author Jacob Lyons (N9507175)
 *
 */
public class ReadManifestCSV {
	 // get instance of store
	  Store store = Store.getInstance();
	  private ArrayList<String> manifestItems;
	  private ArrayList<Integer> quantityBrought;
	  private double totalManifestCost;
	
	  /**
	   * This method reads the manifest CSV and writes the item name and 
	   * quantity brought to separate array lists. The method also checks if the 
	   * CSV has the correct number of fields and contains the correct information.
	   * 
	   * @param fileNameAndPath		-file name and path of the manifest CSV
	   * @throws CSVFormatException	
	   * @throws IOException
	   * @throws StockException
	   * 
	   * @author Jacob Lyons (N9507175)
	   */
	public ReadManifestCSV(String fileNameAndPath) throws CSVFormatException, IOException, StockException {
		
		manifestItems = new ArrayList<String>();
		quantityBrought = new ArrayList<Integer>();
		totalManifestCost = 0;
		
		FileReader fileReader = new FileReader(fileNameAndPath);
		BufferedReader buffer =new BufferedReader(fileReader); 
		String line = buffer.readLine();
		  
		if(line == null) {
			buffer.close();
			throw new CSVFormatException("file is empty");
		}
		  
		// read Manifest CSV line by line 
		while(line != null) {
			String[] parts = line.split(",");
			// check if CSV is correctly formatted
			if((parts.length > 2)|(parts.length < 1)) {
				buffer.close();
				throw new CSVFormatException("Incorect number of feilds in manifest Log CSV");
			}
			  
			if(parts.length == 2) {
				// convert to correct types
				String itemName = parts[0];
				int quantityBrought = Integer.parseInt(parts[1]);  
				
				// add to arrays
				manifestItems.add(itemName);
				this.quantityBrought.add(quantityBrought);
				
			}else if(parts[0].contains(">")){
				manifestItems.add(parts[0]);
				quantityBrought.add(-1);
				
			} else {
				buffer.close();
				throw new CSVFormatException("Incorect data in CSV truck fiels");
			}
			// load next line
			line = buffer.readLine();
		}
		buffer.close(); 
		updateInventory();
	}
	

	
	/**
	 * This method updates brought items quantity and the stores capital, using the data 
	 * read into the array lists.
	 * 
	 * @throws StockException
	 * @author Jacob Lyons (N9507175)
	 */
	public void updateInventory() throws StockException{
	int quantityCount = 0;
	Integer temperatureLevel = 30;
	Item currentItem = null;
	
		for(int i = manifestItems.size()-1; i >= 0 ; i--) {	
			
			if(! manifestItems.get(i).contains(">")) {
				try {
					// check if item reference exists 
					currentItem = store.getInventory().getItemName(manifestItems.get(i));
					// update item quantity
					currentItem.setAmount(currentItem.getAmount()+quantityBrought.get(i));
						
				} catch (StockException e) {
					// catch all possible exceptions and undo changes made to inventory
					undoItemQuantityChanges(i, e.getMessage());
				}

					// update total cost
					totalManifestCost += (double)quantityBrought.get(i)*currentItem.getCostPrice();
					// update counters
					quantityCount += quantityBrought.get(i);
					
					// update truck temperature
					Integer itemTemperature = currentItem.getTemperature();
					if(itemTemperature == null) {
						itemTemperature = 1000;
					}
					if(temperatureLevel > itemTemperature) {
						temperatureLevel = itemTemperature;
					}
						
					// calculate cost of trucks
				}else if(temperatureLevel > 10) {
					totalManifestCost += 750 + 0.25*quantityCount;
					temperatureLevel = 30;
					quantityCount = 0;
						
				}else if(temperatureLevel <= 10) {
					if((temperatureLevel < -20)|(temperatureLevel > 10)) {
						undoItemQuantityChanges(i, manifestItems.get(i)+" is outside trucks Temperature range.");
					}
					totalManifestCost += 900 + 200.00*Math.pow(0.70, temperatureLevel/5.00);

					temperatureLevel = 30;
					quantityCount = 0;
				}
		}
		// update stores capital
		store.setCapital(store.getCapital()-totalManifestCost);			
	}
	
	/**
	 * This method undoes the changes made to the stores stock if an exception
	 * occurs in the updateInventory method.
	 * 
	 * @param index	-the index of the array list witch exception occurred
	 * @throws StockException
	 * 
	 * @author Jacob Lyons
	 */
	public void undoItemQuantityChanges(int index, String errorMessage) throws StockException {
		Item currentItem;
		for(int i = manifestItems.size()-1; i >= index+1 ; i--) {
			if(! manifestItems.get(i).contains(">")) {
				currentItem = store.getInventory().getItemName(manifestItems.get(i));
				// update item quantity 
				currentItem.setAmount(currentItem.getAmount()-quantityBrought.get(i));
			}
		}
		throw new StockException(errorMessage+"\n"+ "No change has been made to the stores inventory.");
	}

	
}
