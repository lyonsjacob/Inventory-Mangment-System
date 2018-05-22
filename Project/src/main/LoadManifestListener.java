package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import exceptions.CSVFormatException;
import exceptions.StockException;
import readInCSV.CSVFormatCheck;
import readInCSV.ReadItemCSV;
import readInCSV.ReadManifestCSV;

/**
 * A listener for the Load Manifest button.
 * @author Mitchell Willemse & Jacob Lyons.
 *
 */
public class LoadManifestListener implements ActionListener {

	/**
	 * Invoked when an action occurs.
	 * @author Mitchell Willemse (n9470620) & Jacob Lyons(N9507175).
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ErrorMessageBox popUpBox = new ErrorMessageBox();
		CSVFormatCheck CSVcheck = new CSVFormatCheck();
		FileSelector fileSelector  = new FileSelector();
		
		String fileNamePath = fileSelector.getFile();
		

			try {
				if(CSVcheck.checkCSVFormat(fileNamePath)) {
					ReadManifestCSV readManifestCSV = new ReadManifestCSV(fileNamePath);
				}
			} catch (CSVFormatException | IOException | StockException e1) {
				popUpBox.ErrorMessage(e1.getMessage());
				e1.printStackTrace();
			}
			
		DataTable table = DataTable.getInstance();
		table.updateTable();

	}

}
