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
	 * Opens a dialog box for the user to choose a location on the file system. Takes in
	 * a string and exports this to a CSV file in the selected location.
	 * @param fileNameAndPath The file name and location on the file system.
	 * @param message The string to export to CSV.
	 * @return Whether the operation succeeded.
	 * @throws CSVFormatException
	 * @throws IOException 
	 * @author Mitchell Willemse (n9470620);
	 */
	public static Boolean writeToCSV(File fileNameAndPath, String message) throws CSVFormatException, IOException {
		FileWriter writer = new FileWriter(fileNameAndPath);
		
		writer.write(message);
		writer.close();
		
		return false;
	}

}
