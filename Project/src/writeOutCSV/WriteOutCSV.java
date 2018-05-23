package writeOutCSV;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import exceptions.CSVFormatException;

/**
 * A class that holds the method to write a string to CSV file.
 * @author Mitchell Willemse (n9470620).
 *
 */
public class WriteOutCSV {
	
	/**
	 * Takes in a string and exports this to a CSV file in the selected location.
	 * Checks to ensure correct formating for CSV.
	 * @param fileNameAndPath The file name and location on the file system.
	 * @param message The string to export to CSV.
	 * @throws CSVFormatException
	 * @throws IOException 
	 * @author Mitchell Willemse (n9470620);
	 */
	public static void writeToCSV(File fileNameAndPath, String message) throws CSVFormatException, IOException {
		//Regex of how Manifest should be output as a string.
		String regex = "(>Ordinary)|(>Refrigerated)|((?s)(.*),(\\d)*)\\R$";
		
		//Check message if message is empty.
		if(message == null) {
			throw new CSVFormatException("No Manifest to Create!");	
		}
		
		//Check if message doesn't matches Regex.
		if (!message.matches(regex)) {
			throw new CSVFormatException("Error formatting Manifest!");	
		}
		
		//Create FileWriter.
		FileWriter writer = new FileWriter(fileNameAndPath);
		
		//Write message.
		writer.write(message);
		
		//Close writer.
		writer.close();
	}
}
