package pl.polsl.controllers;

import pl.polsl.models.Number;
import java.nio.charset.StandardCharsets;

public class Converter
{
	public static String convertNumeralSystem(Number originalNumber, int targetSys)
	{
		String targetValue = "";

		// Convert value of integer part, from decimal to target system.
		int currentValue = Parser.parseDoubleToInt(originalNumber.getValueInDecimalSystem());
		if (currentValue == 0)
		{
			targetValue = "0";
		}

		while (currentValue != 0)
		{
			if (currentValue % targetSys <= 9)
			{
				targetValue = Parser.parseIntToString(currentValue % targetSys) + targetValue;
			}
			else
			{
				char letterFromNumber = Parser.parseIntToChar(currentValue % targetSys + 55);
				targetValue = Parser.parseCharToString(letterFromNumber) + targetValue;
			}

			currentValue /= targetSys;
		}

		return targetValue;
	}

	public static double convertToDecimalValue(Number number)
	{
		double valueInDecimal = 0;

		if (number.getNumeralSystem() == 10)
		{
			valueInDecimal = Parser.parseStringToDouble(number.getValue());
		}
		else
		{
			double index = 0;

			// Iterating through numbers of original number.
			for (int i = number.getValue().length() - 1; i >= 0; i--)
			{
				// Establishing value of current character.
				double symbolValue = 0;
				double asciiCode = number.getValue().getBytes(StandardCharsets.US_ASCII)[i];

				// In case of a number.
				if (asciiCode >= 48 && asciiCode <= 57)
				{
					symbolValue = asciiCode - 48;
				}
				// In case of an upper case letter.
				else if (asciiCode >= 65 && asciiCode <= 90)
				{
					symbolValue = asciiCode - 55;
				}
				// In case of a lower case letter.
				else if (asciiCode >= 97 && asciiCode <= 122)
				{
					symbolValue = asciiCode - 87;
				}

				valueInDecimal += symbolValue * Math.pow(Parser.parseIntToDouble(number.getNumeralSystem()), index);
				index++;
			}
		}

		return valueInDecimal;
	}
}
