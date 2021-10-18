package pl.polsl.controllers;

import pl.polsl.models.exceptions.InvalidParameterException;
import pl.polsl.views.Output;
import pl.polsl.views.Input;
import pl.polsl.models.Number;

public class App
{
	public static void main(String[] args) throws InvalidParameterException
	{
		// First arg is value, second arg is original system, third arg is target system.
		String valueInput;
		String originalSystemInput;
		String targetSystemInput;

		// Get user input.
		if(args.length == 3)
		{
			valueInput = args[0];
			originalSystemInput = args[1];
			targetSystemInput = args[2];
		}
		else
		{
			Output.showStringConsole("Invalid parameters, launching console user interface...");
			Output.showStringConsole("___");
			Output.showStringConsole("What number do you wish to convert:");
			valueInput = Input.getStringConsole();
			Output.showStringConsole("Select this number's numeral system (min:2, max:36):");
			originalSystemInput = Input.getStringConsole();
			Output.showStringConsole("Select target numeral system to convert to (min:2, max:36):");
			targetSystemInput = Input.getStringConsole();
			Output.showStringConsole("___");
		}

		// Validate user input.
		try
		{
			Validator.validateParameters(valueInput, originalSystemInput, targetSystemInput);
		}
		catch (InvalidParameterException e)
		{
			return;
		}

		// Convert numeral system and display the result.
		Number number = new Number(valueInput, Parser.parseStringToInt(originalSystemInput));
		String result = Converter.convertNumeralSystem(number, Parser.parseStringToInt(targetSystemInput));
		Output.showStringConsole(result);
	}
}
