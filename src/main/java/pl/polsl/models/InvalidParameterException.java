package pl.polsl.models;

/**
 * Class representing an exception thrown if algorithm parameter is invalid.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class InvalidParameterException extends Exception {

	/**
	 * Class constructor.
	 *
	 * @param message Exception message.
	 */
	public InvalidParameterException(String message) {
		super(message);
	}
}
