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
		
		Item testItem1 = new Item(0, "Ice", 1, 1, 1, 200,0);
		Item testItem2 = new Item(0, "Frozen Vegtables", 1, 1, 1, 300,-6);
		Item testItem3 = new Item(0, "Coffee", 1, 1, 1, 400);
		Item testItem4 = new Item(0, "Chips", 1, 1, 1, 100);
		Item testItem5 = new Item(0, "Bread", 1, 1, 1, 100);
		Item testItem6 = new Item(0, "Cookies", 1, 1, 1, 100);
		Item testItem7 = new Item(0, "Ice Cream", 1, 1, 1, 100,-20);
		Item testItem8 = new Item(0, "Coke", 1, 1, 1, 100, 3);
		Item testItem9 = new Item(0, "Pasta", 1, 1, 1, 100);
		
		try {
			stock.put(testItem1);
			stock.put(testItem2);
			stock.put(testItem3);
			stock.put(testItem4);
			stock.put(testItem5);
			stock.put(testItem6);
			stock.put(testItem7);
			stock.put(testItem8);
			stock.put(testItem9);
			
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
