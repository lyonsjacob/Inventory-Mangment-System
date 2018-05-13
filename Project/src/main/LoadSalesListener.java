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
		
		try {
			if(CSVcheck.checkCSVFormat("/home/jake/Desktop/sales_log_0.csv")) {
				ReadSalesLogCSV readSalesLogCSV = new ReadSalesLogCSV("/home/jake/Desktop/sales_log_0.csv");
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
