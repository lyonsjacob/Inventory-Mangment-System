package readInCSV;

import java.io.File;
import java.io.IOException;

import exceptions.CSVFormatException;
import exceptions.StockException;

public class CSVFormatCheck {
	
	/**
	 * This method checks if the file and file path exists in the local environment.
	 * Then it check if the file format if not it throws a CSVFormatException.
	 * Finally it returns true if file has the correct format.
	 * 
	 * @param fileNameAndPath
	 * @throws CSVFormatException
	 * @throws IOException
	 * @throws StockException
	 * @author Jacob Lyons
	 */
	public boolean checkCSVFormat(String fileNameAndPath) throws CSVFormatException, IOException, StockException{
		File readFile = new File(fileNameAndPath);
		
		// check it file exists.
		if(!(readFile.exists())) {
			throw new CSVFormatException("File does not exist");
		} 
		
		// check if file format is correct
        if(fileNameAndPath.lastIndexOf(".") != -1 && fileNameAndPath.lastIndexOf(".") != 0) {  	
        	String fileType =fileNameAndPath.substring(fileNameAndPath.lastIndexOf(".")+1);
    		String fileFormat = "csv";
    		
        	if(!fileFormat.equals(fileType)) {
        		throw new CSVFormatException("Incorrect file format, csv file format muct be used");
        	}
        }
        else {
        	throw new CSVFormatException("csv file not found");
        }
        return true;
	}

}
