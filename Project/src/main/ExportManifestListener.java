package main;

import writeOutCSV.WriteOutCSV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import exceptions.CSVFormatException;
import exceptions.DeliveryException;
import exceptions.StockException;
import manifest.Manifest;
import manifestCreator.ManifestCreator;
import store.Store;

/**
 * A listener for the Export Manifest button.
 * @author Mitchell Willemse (n9470620) & Jacob Lyons.
 */
public class ExportManifestListener implements ActionListener {

	/**
	 * Invoked when Export Manifest button is clicked.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		createManifest();
	}
	
	
	
	/**
	 * Shows a dialog box that allows the user to choose a directory to save their
	 * manifest too. The manifest is then generated based on the store's inventory and
	 * exported as a .csv file to the chosen location. Shows an error message box when
	 * exceptions occur.
	 * @author Mitchell Willemse (n9470620).
	 */
	public void createManifest() {
		//Create ErrorMessageBox.
		ErrorMessageBox popUpBox = new ErrorMessageBox();
		
		//Create new Manifest.
		Manifest manifest = new Manifest();

		try {
			//Use manifest creator to generate manifest from the stores inventory.
			manifest = ManifestCreator.CreateManifest(Store.getInstance().getInventory());
			
		} catch (StockException e1) {
			//Show user error message.
			popUpBox.ErrorMessage(e1.getMessage());
		} catch (DeliveryException e2) {
			//Show user error message.
			popUpBox.ErrorMessage(e2.getMessage());
		}
		
		//No items need to be ordered, or no items are in the inventory.
		if (manifest == null) {
			popUpBox.ErrorMessage("No Manifest to Create!");
			return;
		}
		
		//Create new save file dialog.
		JFileChooser fileChooser = new JFileChooser();
		
		//Add CSV file filter
		FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("CSV File (*.csv)", "csv");
		fileChooser.setFileFilter(csvFilter);
		
		if (fileChooser.showSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
			try {
				//use WriteOutCSV to output the file as a CSV in selected directory.
				File file = fileChooser.getSelectedFile();
				
				//Append CSV
				file = new File(file.toString() + ".csv"); 
				
				//Write the file out.
				WriteOutCSV.writeToCSV(file, manifest.getTruckString());
				
			} catch (CSVFormatException e1) {
				//Show user error message.
				popUpBox.ErrorMessage(e1.getMessage());
			} catch (IOException e2) {
				//Show user error message.
				popUpBox.ErrorMessage(e2.getMessage());
			}
		  
		}
		
		//Update table.
		UpdateGUIElements table = UpdateGUIElements.getInstance();
		table.updateTable();
		table.updateLable();
	}
}
