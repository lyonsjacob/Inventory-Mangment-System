package exceptions;

/**
 * A trivial exception class for CSV formatting issues.
 * 
 * @author Mitchell Willemse
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
