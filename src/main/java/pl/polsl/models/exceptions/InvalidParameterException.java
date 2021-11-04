package pl.polsl.models.exceptions;

/**
 * Class representing an exception thrown if algorithm parameter is invalid.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class InvalidParameterException extends Exception {

	public InvalidParameterException(String message) {
		super(message);
	}
}
