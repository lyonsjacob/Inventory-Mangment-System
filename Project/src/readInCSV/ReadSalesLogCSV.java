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
 * This class reads in a sales log csv. The condense of the csv are stored in memory.
 * The items quantity and the stores capital are then updated. if an exception occurs 
 * during this process the changes are reversed and a message is sent to the user.
 * 
 * @author Jacob Lyons (N9507175)
 */
public class ReadSalesLogCSV {
	  // get instance of store
	  Store store = Store.getInstance();
	  private ArrayList<String> soldItems;
	  private ArrayList<Integer> quantitySold;
	
	/**
	 * This method reads the sales log CSV and writes the item name and 
	 * quantity sold to separate array lists. The method also checks if the 
	 * CSV has the correct number of fields and contains the correct information.
	 * 
	 * @param fileNameAndPath		-file name and path of sales log CSV
	 * @throws CSVFormatException
	 * @throws IOException
	 * @throws StockException
	 * 
	 * @author Jacob Lyons (N9507175)
	 */
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
	
	
	/**
	 * This method updates the sold items quantity in inventory and the stores capital, 
	 * using the data read into the array lists.
	 * 
	 * @throws StockException
	 * 
	 * @author Jacob Lyons
	 */
	public void updateInventory() throws StockException {
		
		Item currentItem;
		
		for(int i=0; i < soldItems.size(); i++) {
			// Check it item exist and undo all changes if item does not exist
			System.out.println(soldItems.get(i));
			System.out.println(quantitySold.get(i));
			
		    try {
				currentItem = store.getInventory().getItemName(soldItems.get(i));
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
	
	
	/**
	 * This method undoes the changes made to the stores stock and capital if an exception
	 * occurs in the updateInventory method.
	 * 
	 * @param index -the index of the array list witch exception occurred
	 * @throws StockException
	 */
	public void undoChanges(int index) throws StockException {
		Item currentItem;
		for(int i=0; i < index; i++) {
			
			//get item
			currentItem = store.getInventory().getItemName(soldItems.get(i));
			
			// update item quantity 
			currentItem.setAmount(currentItem.getAmount()-quantitySold.get(i));
						
			// update capital
			double grossProfit = (double)quantitySold.get(i)*currentItem.getSellPrice();
			store.setCapital(store.getCapital()+grossProfit);			
			
		}
		
		throw new StockException("Item is not in store inventory or the amount sold is larger than the amount in stock");
	}

}
