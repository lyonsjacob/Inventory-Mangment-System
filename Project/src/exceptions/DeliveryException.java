package exceptions;

/**
 * A trivial exception class for delivery issues.
 * @author Mitchell Willemse (n9470620).
 */

public class DeliveryException extends Exception {
	
	/**
	 * Auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = -4028052505995012486L;

	/**
	 * Constructs a new exception with null as its detail message.
	 * @author Mitchell Willemse (n9470620).
	 */
	public DeliveryException() {
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 * @param message The detail message.
	 * @author Mitchell Willemse (n9470620).
	 */
	public DeliveryException(String message) {
		super(message);
	}

}
