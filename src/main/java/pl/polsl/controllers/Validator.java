package pl.polsl.controllers;

import pl.polsl.models.exceptions.InvalidParameterException;

import java.nio.charset.StandardCharsets;

public class Validator
{
	public static void validateParameters(String numberValue, String originalSystem, String targetSystem) throws InvalidParameterException
	{
		// Parameters can't be empty anyways, so no need to check that.
		checkIfNumeralSystemExists(originalSystem);
		checkIfNumeralSystemExists(targetSystem);
		checkIfNumberExistsInGivenSystem(numberValue, originalSystem);
	}

	private static void checkIfNumberExistsInGivenSystem(String numberValue, String systemToCheck) throws InvalidParameterException
	{
		int systemValue = Parser.parseStringToInt(systemToCheck);

		for (int i = 0; i < numberValue.length(); i++)
		{
			double asciiCode = numberValue.getBytes(StandardCharsets.US_ASCII)[i];

			// In case of a number
			if (asciiCode >= 48 && asciiCode <= 57 && systemValue <= asciiCode - 48)
			{
				throw new InvalidParameterException("'" + numberValue + "' isn't a valid value in numeral system - " + systemToCheck);
			}
			// In case of an upper case letter
			else if (asciiCode >= 65 && asciiCode <= 90 && systemValue <= asciiCode - 55)
			{
				throw new InvalidParameterException("'" + numberValue + "' isn't a valid value in numeral system - " + systemToCheck);
			}
			// In case of a lower case letter
			else if (asciiCode >= 97 && asciiCode <= 122 && systemValue <= asciiCode - 87)
			{
				throw new InvalidParameterException("'" + numberValue + "' isn't a valid value in numeral system - " + systemToCheck);
			}
			// In case of other character
			else if (asciiCode < 48 || (asciiCode > 57 && asciiCode < 65) || (asciiCode > 90 && asciiCode < 97) || asciiCode > 122)
			{
				throw new InvalidParameterException("'" + numberValue + "' isn't a valid value in numeral system - " + systemToCheck);
			}
		}
	}

	private static void checkIfNumeralSystemExists(String numeralSystem) throws InvalidParameterException
	{
		checkIfNumeralSystemIsNumeric(numeralSystem);

		int systemValue = Parser.parseStringToInt(numeralSystem);

		if(!(systemValue >= 2 && systemValue <= 36))
		{
			throw new InvalidParameterException("'" + numeralSystem + "' isn't a valid numeral system (min:2, max:36).");
		}
	}

	private static void checkIfNumeralSystemIsNumeric(String numeralSystem) throws InvalidParameterException
	{
		try
		{
			Double.parseDouble(numeralSystem);
		}
		catch(NumberFormatException e)
		{
			throw new InvalidParameterException("'" + numeralSystem + "' isn't a valid numeral system - invalid characters (min:2, max:36).");
		}
	}
}
