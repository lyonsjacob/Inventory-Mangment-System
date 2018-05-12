package exceptions;

/**
 * A trivial exception class for CSV formatting issues.
 * 
 * @author Mitchell Willemse (n9470620).
 *
 */

@SuppressWarnings("serial")
public class CSVFormatException extends Exception {
	
	public CSVFormatException() {
		super();
	}

	public CSVFormatException(String message) {
		super(message);
	}

}
