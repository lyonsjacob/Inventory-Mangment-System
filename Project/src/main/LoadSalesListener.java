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
	 * Invoked when an action occurs.
	 * @author Mitchell Willemse (n9470620) & Jacob Lyons (N9507175).
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Load Sales Log");
		
		CSVFormatCheck CSVcheck = new CSVFormatCheck();
		FileSelector fileSelector  = new FileSelector();
		
		String fileNamePath = fileSelector.getFile();
		
		try {
			if(CSVcheck.checkCSVFormat(fileNamePath)) {
				ReadSalesLogCSV readSalesLogCSV = new ReadSalesLogCSV(fileNamePath);
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
