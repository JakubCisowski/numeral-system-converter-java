package pl.polsl.controllers;

import pl.polsl.models.*;
import pl.polsl.models.Number;
import pl.polsl.views.Output;
import java.util.*;

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

		List<InputSet> inputSetList = new ArrayList<>();
		InputSet inputSet = new InputSet();

		String numberValueInput;
		String originalSystemInput;
		String targetSystemInput;

		// Get user input.
		if (args.length == 3) {
			inputSet.setNumberValue(args[0]);
			inputSet.setOriginalSystem(args[1]);
			inputSet.setTargetSystem(args[2]);

			inputSetList.add(inputSet);
		}
		else {
			output.showStringConsole("Invalid parameters, launching console user interface...");
			output.showStringConsole("___");
			output.showStringConsole("What number do you wish to convert:");
			inputSet.setNumberValue(input.getStringConsole());
			output.showStringConsole("Select this number's numeral system (min:2, max:36):");
			inputSet.setOriginalSystem(input.getStringConsole());
			output.showStringConsole("Select target numeral system to convert to (min:2, max:36):");
			inputSet.setTargetSystem(input.getStringConsole());
			output.showStringConsole("___");
		}

		// Validate user input.
		try {
			validator.validateParameters(inputSet.getNumberValue(), inputSet.getOriginalSystem(), inputSet.getTargetSystem());
		} catch (InvalidParameterException e) {
			output.showErrorConsole(e.getMessage());
			return;
		}

		// Convert numeral system and display the result.
		Number number = new Number(inputSet.getNumberValue(), Integer.parseInt(inputSet.getOriginalSystem()));
		String result = converter.convertNumeralSystem(number,  Integer.parseInt(inputSet.getTargetSystem()));
		output.showStringConsole(result);
	}
}
