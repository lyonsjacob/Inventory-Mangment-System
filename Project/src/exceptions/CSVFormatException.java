package exceptions;

/**
 * A trivial exception class for CSV formatting issues.
 * @author Mitchell Willemse (n9470620).
 */

public class CSVFormatException extends Exception {
	
	/**
	 * Auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 3519252823603207693L;

	/**
	 * Constructs a new exception with null as its detail message.
	 * @author Mitchell Willemse (n9470620).
	 */
	public CSVFormatException() {
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 * @param message The detail message.
	 * @author Mitchell Willemse (n9470620).
	 */
	public CSVFormatException(String message) {
		super(message);
	}

}
