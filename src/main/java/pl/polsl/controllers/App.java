package pl.polsl.controllers;

import pl.polsl.models.Converter;
import pl.polsl.models.Validator;
import pl.polsl.models.InvalidParameterException;
import pl.polsl.views.Output;
import pl.polsl.models.Number;

/**
 * Main class of the application, as well as its entry point, containing only 'main' method.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class App {
	/**
	 * Main method of the application, converts a number (passed by app parameters or console input) from its original to selected target numeral system.
	 * Example: Input: "10 10 2" converts number ("10") represented in decimal (10) numeral system into binary (2) and displays the result in console ("1010").
	 * If passed parameters are not valid, this method launches console user interface which tries to get user input once again and displays result after successful validation.
	 *
	 * @param args 3 parameters: 1st is a number to convert, 2nd is this number's numeral system, 3rd is target numeral system of the conversion. Both numeral systems are numeric values in range 2 to 36.
	 */
	public static void main(String[] args) {
		Input input = new Input();
		Output output = new Output();
		Converter converter = new Converter();
		Validator validator = new Validator();

		String numberValueInput;
		String originalSystemInput;
		String targetSystemInput;

		// Get user input.
		if (args.length == 3) {
			numberValueInput = args[0];
			originalSystemInput = args[1];
			targetSystemInput = args[2];
		}
		else {
			output.showStringConsole("Invalid parameters, launching console user interface...");
			output.showStringConsole("___");
			output.showStringConsole("What number do you wish to convert:");
			numberValueInput = input.getStringConsole();
			output.showStringConsole("Select this number's numeral system (min:2, max:36):");
			originalSystemInput = input.getStringConsole();
			output.showStringConsole("Select target numeral system to convert to (min:2, max:36):");
			targetSystemInput = input.getStringConsole();
			output.showStringConsole("___");
		}

		// Validate user input.
		try {
			validator.validateParameters(numberValueInput, originalSystemInput, targetSystemInput);
		} catch (InvalidParameterException e) {
			output.showErrorConsole(e.getMessage());
			return;
		}

		// Convert numeral system and display the result.
		Number number = new Number(numberValueInput, Integer.parseInt(originalSystemInput));
		String result = converter.convertNumeralSystem(number,  Integer.parseInt(targetSystemInput));
		output.showStringConsole(result);
	}
}
