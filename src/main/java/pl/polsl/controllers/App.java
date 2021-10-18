package pl.polsl.controllers;


import pl.polsl.views.Output;
import pl.polsl.views.Input;

public class App
{
	public static void main(String[] args)
	{
		Output consoleOutput = new Output();
		Input consoleInput = new Input();

		// First arg is value, second arg is target system
		String valueInput;
		String targetSystemInput;

		// If args.length == 0, ask user for input in console.
		if(args.length == 2)
		{
			valueInput = args[0];
			targetSystemInput = args[1];

			// todo: Validate arguments.
		}
		else
		{

			consoleOutput.ShowStringConsole("What number do you wish to convert?");
			valueInput = consoleInput.GetStringConsole();
			consoleOutput.ShowStringConsole("Select target system (2/10)");
			targetSystemInput = consoleInput.GetStringConsole();

			// todo: delete
			consoleOutput.ShowStringConsole(valueInput);
			consoleOutput.ShowStringConsole(targetSystemInput);

			// todo: Validate console input.
		}
	}
}
