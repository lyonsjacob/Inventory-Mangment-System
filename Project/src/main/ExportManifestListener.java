package main;
import writeOutCSV.WriteOutCSV;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import exceptions.CSVFormatException;
import exceptions.DeliveryException;
import exceptions.StockException;
import manifest.Manifest;
import manifestCreator.ManifestCreator;
import store.Store;

/**
 * A listener for the Export Manifest button.
 * @author Mitchell Willemse & Jacob Lyons.
 *
 */
public class ExportManifestListener implements ActionListener {

	/**
	 * Invoked when an action occurs.
	 * @author Mitchell Willemse (n9470620).
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		

		
		System.out.println("Export Manifest");
		
		Manifest manifest = new Manifest();

		try {
			manifest = ManifestCreator.CreateManifest(Store.getInstance().getInventory());
			System.out.println(manifest.getTruckString());
		} catch (StockException | DeliveryException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}
		
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
			try {
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
		
		DataTable table = DataTable.getInstance();
		table.updateTable();
	}

}
