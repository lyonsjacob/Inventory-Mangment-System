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
	 * Invoked when an action occurs.
	 * @author Mitchell Willemse (n9470620) & Jacob Lyons (n9507175).
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Load Items");
		CSVFormatCheck CSVcheck = new CSVFormatCheck();
		
		// TODO: Handle Exceptions
		try {
			if(CSVcheck.checkCSVFormat("/home/jake/Desktop/item_properties.csv")) {
			ReadItemCSV readitemCSV = new ReadItemCSV("/home/jake/Desktop/item_properties.csv");
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
