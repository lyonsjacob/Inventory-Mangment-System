package main;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;

import exceptions.CSVFormatException;
import exceptions.StockException;
import readInCSV.CSVFormatCheck;
import readInCSV.ReadItemCSV;

/**
 * A listener for the Load Items button.
 * @author Mitchell Willemse & Jacob Lyons.
 *
 */
public class LoadListener implements ActionListener {

	/**
	 * Invoked when "load Item" button press occurs this method 
	 * asks the user to select a file using Java's in built File Selector GUI.
	 * The selected file format is check in the CSVFormatCheck()
	 * before being passed to the ReadItemCSV() class witch
	 * reads the file and updates the stores inventory and capital.
	 * UpdateGUIElements is then called to update the JTable and
	 * JLable displayed in the GUI.
	 * 
	 * All exceptions are handled in the method by passing the 
	 * error message to the user in the form of a pop up window.
	 * 
	 * @author Jacob Lyons (N9507175).
	 */
	public void actionPerformed(ActionEvent e) {
		// Initialize classes needed
		ErrorMessageBox popUpBox = new ErrorMessageBox();
		CSVFormatCheck CSVcheck = new CSVFormatCheck();
		FileSelector fileSelector  = new FileSelector();
		
		// Get file from file selector GUI.
		String fileNamePath = fileSelector.getFile();
		
			try {
				// Check file format
				if(CSVcheck.checkCSVFormat(fileNamePath)) {
				ReadItemCSV readitemCSV = new ReadItemCSV(fileNamePath);
				}
			} catch (CSVFormatException | IOException | StockException e1) {
				e1.printStackTrace();
				// Display exception message in pop up window
				popUpBox.ErrorMessage(e1.getMessage());
			}
			
	// Update the GUI.
	UpdateGUIElements table = UpdateGUIElements.getInstance();
	table.updateTable();
	table.updateLable();
		
	}

}
