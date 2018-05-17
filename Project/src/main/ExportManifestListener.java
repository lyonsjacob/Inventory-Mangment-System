package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		// TODO Auto-generated method stub
		System.out.println("Export Manifest");
		
		Manifest manifest = new Manifest();

		try {
			manifest = ManifestCreator.CreateManifest(Store.getInstance().getInventory());
			System.out.println(manifest.getTruckString());
		} catch (StockException | DeliveryException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}
	}

}
