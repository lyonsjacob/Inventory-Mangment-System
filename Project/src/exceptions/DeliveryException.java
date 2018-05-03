package exceptions;

/**
 * A trivial exception class for delivery issues.
 * 
 * @author Mitchell Willemse
 *
 */

@SuppressWarnings("serial")
public class DeliveryException extends Exception {
	
	public DeliveryException() {
		super();
	}

	public DeliveryException(String message) {
		super(message);
	}

}