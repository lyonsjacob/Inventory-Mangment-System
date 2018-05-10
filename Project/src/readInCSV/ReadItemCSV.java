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
	 
	
	//TODO put this in a class of it own for generally checking file format
	/**
	 * This class checks if the file and file path exists in the local environment.
	 * Then it check if the file format if not it throws a CSVFormatException.
	 * Finally it returns true if file has the correct fomat.
	 * 
	 * @param fileNameAndPath
	 * @throws CSVFormatException
	 * @throws IOException
	 * @throws StockException
	 * @author Jacob Lyons
	 */
	public ReadItemCSV(String fileNameAndPath) throws CSVFormatException, IOException, StockException{
		File readFile = new File(fileNameAndPath);
		
		// check it file exists.
		if(!(readFile.exists())) {
			throw new CSVFormatException("File does not exist");
		} 
		
		// check if file format is correct
        if(fileNameAndPath.lastIndexOf(".") != -1 && fileNameAndPath.lastIndexOf(".") != 0) {
        	String fileType =fileNameAndPath.substring(fileNameAndPath.lastIndexOf(".")+1);
        	if("csv" != fileType) {
        		throw new CSVFormatException("Incorrect file format, csv file fomat muct be used");
        	}
        }
        else {
        	throw new CSVFormatException("csv file not found");
        }
        
        readInItemCSV(fileNameAndPath);
	}
	
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
	public void readInItemCSV(String fileNameAndPath) throws CSVFormatException, IOException, StockException {
		
		  FileReader fileReader = new FileReader("fileNameAndPath");
		  BufferedReader buffer =new BufferedReader(fileReader); 
		  String line = buffer.readLine();
		  if(line == null) {
			  buffer.close();
			  throw new CSVFormatException("file is empty");
		  }
		  
		  // get instance of store
		  Store store = Store.getInstance();
		  // clear store inventory 
		  // TODO make clear inventory method.
		  
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
			  
		  }
		  buffer.close();	  
	}

}

















