package pl.polsl.views;

/**
 * Class responsible for displaying output.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class Output {
	/**
	 * Method showing multiple strings to console.
	 *
	 * @param messages Messages to show.
	 */
	public void showStringConsole(String... messages) {
		for (String message : messages) {
			System.out.println(message);
		}
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

