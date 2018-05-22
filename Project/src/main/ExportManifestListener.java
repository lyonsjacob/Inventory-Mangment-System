package main;
import writeOutCSV.WriteOutCSV;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
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
 * @author Mitchell Willemse & Jacob Lyons.
 */
public class ExportManifestListener implements ActionListener {

	/**
	 * Invoked when an action occurs.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Create new Manifest.
		Manifest manifest = new Manifest();

		try {
			//Use manifest creator to generate manifest from the stores inventory.
			manifest = ManifestCreator.CreateManifest(Store.getInstance().getInventory());
			
		} catch (StockException | DeliveryException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
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
				WriteOutCSV.writeToCSV(file, manifest.getTruckString());
				
			} catch (CSVFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  
		}
		
		//Update table.
		DataTable table = DataTable.getInstance();
		table.updateTable();
	}

}
