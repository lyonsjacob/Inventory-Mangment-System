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
		// TODO 
		System.out.println("Load Manifest");
		CSVFormatCheck CSVcheck = new CSVFormatCheck();
		
		try {
			if(CSVcheck.checkCSVFormat("/home/jake/Downloads/manifest.csv")) {
				ReadManifestCSV readManifestCSV = new ReadManifestCSV("/home/jake/Downloads/manifest.csv");
			}
		} catch (CSVFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (StockException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
