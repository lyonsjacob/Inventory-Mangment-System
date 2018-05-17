package readInCSV;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import exceptions.CSVFormatException;
import exceptions.StockException;
import item.Item;
import store.Store;

/**
 * This class loads a CSV with format (item, cost, price, reorder point, reorder amount, temperature)
 * The sting is then spilt into individual components and converted to the correct type
 * (sting, double, double, int, int, int). These types are then used to create a new item object.
 * @author Jacob Lyons
 * 
 *
 */
public class ReadItemCSV {

	
	/**
	 * This method takes a file path and opens an item properties csv at that location. Item 
	 * properties are then used to create item objects on the system.
	 * 
	 * @param fileNameAndPath
	 * @throws CSVFormatException
	 * @throws IOException
	 * @throws StockException
	 * @author Jacob Lyons
	 */
	public ReadItemCSV(String fileNameAndPath) throws CSVFormatException, IOException, StockException {
		
		  FileReader fileReader = new FileReader(fileNameAndPath);
		  BufferedReader buffer =new BufferedReader(fileReader); 
		  String line = buffer.readLine();
		  
		  if(line == null) {
			  buffer.close();
			  throw new CSVFormatException("file is empty");
		  }
		  
		  // get instance of store
		  Store store = Store.getInstance();
		  // clear store inventory 
		  store.getInventory().clear();
		  
		  // read CSV line by line 
		  while(line != null) {
			  String[] parts = line.split(",");
			  
			  // check if CSV is correctly formatted
			  if((parts.length > 6)|(parts.length < 5)) {
				  buffer.close();
				  throw new CSVFormatException("Incorect number of feilds in CSV");
			  }
			  
			  // convert to correct types
			  double cost = Double.parseDouble(parts[1]);
			  double price = Double.parseDouble(parts[2]);
			  int reorderPoint = Integer.parseInt(parts[3]);
			  int reorderAmount = Integer.parseInt(parts[4]);
			  
			  // put item in inventory
			  if (parts.length == 6) {
				  int temperature = Integer.parseInt(parts[5]);
				  store.getInventory().put(new Item(0, parts[0], cost, price, reorderPoint, reorderAmount, temperature));
			  } else {
			  store.getInventory().put(new Item(0, parts[0], cost, price, reorderPoint, reorderAmount));
			  }
			  
			  // load next line
			  line = buffer.readLine();
			  
		  }
		  buffer.close();
		  
		  // DE-BUG  
	      for (Item i : store.getInventory()) {
	    	System.out.println(i.toString());
	      }
	        
	}

}

















