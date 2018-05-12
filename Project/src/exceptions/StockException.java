package exceptions;

/**
 * A trivial exception class for stock issues.
 * 
 * @author Mitchell Willemse (n9470620).
 *
 */

@SuppressWarnings("serial")
public class StockException extends Exception {

	public StockException() {
		super();
	}

	public StockException(String message) {
		super(message);
	}

}

