package pl.polsl.views;

/**
 * Class responsible for displaying output.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class Output {
	/**
	 * Method showing string to console.
	 *
	 * @param message Message to show.
	 */
	public void showStringConsole(String message)
	{
		System.out.println(message);
	}

	/**
	 * Method showing error string to console.
	 *
	 * @param message Error message to show.
	 */
	public void showErrorConsole(String message)
	{
		System.err.println(message);
	}
}

