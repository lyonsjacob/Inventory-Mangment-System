package readInCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import exceptions.CSVFormatException;
import exceptions.StockException;
import item.Item;
import store.Store;

public class ReadSalesLogCSV {
	  // get instance of store
	  Store store = Store.getInstance();
	  private ArrayList<String> soldItems;
	  private ArrayList<Integer> quantitySold;
	
	public ReadSalesLogCSV(String fileNameAndPath) throws CSVFormatException, IOException, StockException {
		
		soldItems = new ArrayList<String>();
		quantitySold = new ArrayList<Integer>();
		
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
			if(parts.length != 2) {
				buffer.close();
				throw new CSVFormatException("Incorect number of feilds in Sales Log CSV");
			}
			  
			// convert to correct types
			String itemName = parts[0];
			int quantitySold = Integer.parseInt(parts[1]);
			  
			// add to arrays
			soldItems.add(itemName);
			this.quantitySold.add(quantitySold);
			
			// load next line
			line = buffer.readLine();
		}
		buffer.close(); 
		updateInventory();
	}
	
	
	
	public void updateInventory() throws StockException {
		
		Item currentItem;
		for(int i=0; i < soldItems.size(); i++) {
			// Check it item exist and undo all changes if item does not exist
			
		    try {
				currentItem = store.getInventory().get(soldItems.get(i));
				// update item quantity 
				currentItem.setAmount(currentItem.getAmount()-quantitySold.get(i));	
				// update capital
				double grossProfit = (double)quantitySold.get(i)*currentItem.getSellPrice();
				store.setCapital(store.getCapital()+grossProfit);
				
			} catch (StockException e) {
				undoChanges(i);
			}	
		}  
	}
	
	
	public void undoChanges(int index) throws StockException {
		Item currentItem;
		for(int i=0; i < index; i++) {
			
			//get item
			currentItem = store.getInventory().get(soldItems.get(i));
			
			// update item quantity 
			currentItem.setAmount(currentItem.getAmount()-quantitySold.get(i));
						
			// update capital
			double grossProfit = (double)quantitySold.get(i)*currentItem.getSellPrice();
			store.setCapital(store.getCapital()+grossProfit);			
			
		}
		
		throw new StockException("Item is not in store inventory or the amount sold is larger than the amount in stock");
	}

}
