package exceptions;

/**
 * A trivial exception class for stock issues.
 * @author Mitchell Willemse (n9470620).
 */

public class StockException extends Exception {

	/**
	 * Auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = -4476246509798407708L;

	/**
	 * Constructs a new exception with null as its detail message.
	 * @author Mitchell Willemse (n9470620).
	 */
	public StockException() {
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 * @param message The detail message.
	 * @author Mitchell Willemse (n9470620).
	 */
	public StockException(String message) {
		super(message);
	}
}

