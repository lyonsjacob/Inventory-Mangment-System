package readInCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.CSVFormatException;
import exceptions.StockException;
import item.Item;
import store.Store;


public class ReadManifestCSV {
	 // get instance of store
	  Store store = Store.getInstance();
	  private ArrayList<String> manifestItems;
	  private ArrayList<Integer> quantityBrought;
	  private double totalManifestCost;
	
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
		  
		// read Sales CSV line by line 
		while(line != null) {
			String[] parts = line.split(",");
			  
			// check if CSV is correctly formatted
			if((parts.length > 2)|(parts.length < 1)) {
				buffer.close();
				throw new CSVFormatException("Incorect number of feilds in Sales Log CSV");
			}
			  
			if(parts.length == 2) {
				// convert to correct types
				String itemName = parts[0];
				int quantityBrought = Integer.parseInt(parts[1]);  
				// add to arrays
				manifestItems.add(itemName);
				this.quantityBrought.add(quantityBrought);
				
			}else if((parts[0].equals("ordinary Truck"))|(parts[0].equals("refrigerated Truck"))){
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
	}
	

	public void updateInventory() throws StockException {
		
	int quantityCount;
	int temperatureLevel = 30;
	Item currentItem;
		for(int i = manifestItems.size()-1; i >= 0 ; i--) {
			
			try {
				if(quantityBrought.get(i) !=-1) {
					currentItem = store.getInventory().get(manifestItems.get(i));
					// update item quantity 
					currentItem.setAmount(currentItem.getAmount()+quantityBrought.get(i));
					//update total cost
					totalManifestCost =+ (double)quantityBrought.get(i)*currentItem.getSellPrice();
					//update counters
					quantityCount =+ quantityBrought.get(i);
					
					// update truck temperature
					if(temperatureLevel > currentItem.getTemperature()) {
						temperatureLevel = currentItem.getTemperature();
						
					// calculate cost of trucks
					}else if(manifestItems.get(i).equals("Ordinary Truck")) {
						totalManifestCost += 750 + 0.25*quantityCount;
						temperatureLevel = 30;
						quantityCount = 0;
						
					}else if(manifestItems.get(i).equals("Refrigerated Truck")) {
						totalManifestCost += 900 + 200.00*Math.pow(0.70, temperatureLevel/5.00);
						temperatureLevel = 30;
						quantityCount = 0;
					}
				}
				
			}catch (StockException e) {
				undoItemQuantityChanges(i);
			}	
			// update stores capital
			store.setCapital(store.getCapital()-totalManifestCost);
		}		
	}
	
	public void undoItemQuantityChanges(int index) throws StockException {
		Item currentItem;
		for(int i = manifestItems.size()-1; i >= index+1 ; i--) {
			currentItem = store.getInventory().get(manifestItems.get(i));
			// update item quantity 
			currentItem.setAmount(currentItem.getAmount()-quantityBrought.get(i));
		}
		throw new StockException(manifestItems.get(index)+"is not in store inventory, unable to update manifest");
	}

	
}
