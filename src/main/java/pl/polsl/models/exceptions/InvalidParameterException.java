package pl.polsl.models.exceptions;

import pl.polsl.views.Output;

public class InvalidParameterException extends Exception
{
	public InvalidParameterException(String message)
	{
		Output.showErrorConsole(message);
	}
}
