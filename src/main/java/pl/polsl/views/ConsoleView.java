package pl.polsl.views;

import pl.polsl.models.ConversionSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class responsible for displaying output to console.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class ConsoleView {
	/**
	 * Method showing multiple strings to console.
	 *
	 * @param messages Messages to show.
	 */
	public void showString(String... messages) {
		for (String message : messages) {
			System.out.println(message);
		}
	}

	/**
	 * Method showing error string to console.
	 *
	 * @param message Error message to show.
	 */
	public void showError(String message)
	{
		System.err.println(message);
	}

	/**
	 * Method for displaying registry to console.
	 *
	 * @param registrySet Registry data.
	 * @param useStream Displaying using stream.
	 * */
	public void showRegistry(List<ConversionSet> registrySet, boolean useStream) {
		showString("REGISTRY RECORDS:", "---");

		if(!useStream){
			for (ConversionSet set : registrySet) {
				showString(set.getNumberValue() + "(" + set.getOriginalSystem() + ") = " + set.getConversionResult() + "(" + set.getTargetSystem() + ")");
			}
		}
		else{
			Stream<ConversionSet> stream = registrySet.stream();
			stream.forEach(set -> showString(set.getNumberValue() + "(" + set.getOriginalSystem() + ") = " + set.getConversionResult() + "(" + set.getTargetSystem() + ")"));
		}

	}
}

