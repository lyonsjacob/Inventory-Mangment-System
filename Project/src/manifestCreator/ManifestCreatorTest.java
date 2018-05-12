package manifestCreator;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.DeliveryException;
import exceptions.StockException;
import item.Item;
import manifest.Manifest;
import stock.Stock;

public class ManifestCreatorTest {

	@Test
	public void test() {
		Stock stock = new Stock();
		
		Item testItem1 = new Item(0, "Ice Cream", 3, 4, 200, 800, -20);
		Item testItem2 = new Item(0, "Coffee", 2, 3, 100, 225);
		Item testItem3 = new Item(0, "Milk", 3, 4, 100, 150);
		
		try {
			stock.put(testItem1);
			stock.put(testItem2);
			stock.put(testItem3);
		} catch (StockException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Manifest manifest = new Manifest();

		try {
			manifest = ManifestCreator.CreateManifest(stock);
			System.out.println(manifest.getTruckString());
		} catch (StockException | DeliveryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
