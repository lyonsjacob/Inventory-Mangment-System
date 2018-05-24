package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import exceptions.CSVFormatException;
import exceptions.StockException;
import readInCSV.CSVFormatCheck;
import readInCSV.ReadItemCSV;
import readInCSV.ReadSalesLogCSV;

/**
 * A listener for the Load Sales Log button.
 * @author Mitchell Willemse & Jacob Lyons.
 *
 */
public class LoadSalesListener implements ActionListener {

	/**
	 * Invoked "load Sales Log" button press occurs this method asks the user 
	 * to select a file using Java's in built File Selector gui.
	 * The selected file format is check in the CSVFormatCheck()
	 * before being passed to the ReadSalesLogSCV() class witch
	 * reads the file and updates the stores inventory and capital.
	 * UpdateGUIElements is then called to update the JTable and
	 * JLable displayed in the gui.
	 * 
	 * All exceptions are handled in the method by passing the 
	 * error message to the user in the form of a pop up window.
	 * 
	 * @author Jacob Lyons (N9507175).
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Initialize needed classes;
		ErrorMessageBox popUpBox = new ErrorMessageBox();
		CSVFormatCheck CSVcheck = new CSVFormatCheck();
		FileSelector fileSelector  = new FileSelector();
		
		// Get file from file selector GUI
		String fileNamePath = fileSelector.getFile();
		
			try {
				// Check file format
				if(CSVcheck.checkCSVFormat(fileNamePath)) {
					// Make changes to inventory.
					ReadSalesLogCSV readSalesLogCSV = new ReadSalesLogCSV(fileNamePath);
				}
			} catch (CSVFormatException | IOException | StockException e1) {
				e1.printStackTrace();
				// Display exception message in pop up window. 
				popUpBox.ErrorMessage(e1.getMessage());
			}
	    // Update infromation in the GUI
		UpdateGUIElements table = UpdateGUIElements.getInstance();
		table.updateTable();
		table.updateLable();
	}

}
