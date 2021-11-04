package pl.polsl.models;

import java.nio.charset.StandardCharsets;

/**
 * Main algorithm class, responsible for converting numbers into any numeral systems.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class Converter {
	/**
	 * Method taking an original number (which contains both its value and its numeral system) and converting it into the target system.
	 * Example: originalNumber is a number with value "10", and numeral system 10, targetSystem is 2, the string "1010" is returned.
	 *
	 * @param originalNumber Compressed user input (contains number value and its system).
	 * @param targetSystem   Target numeral system of the conversion, example: 16.
	 * @return Converted value represented in targetSystem, example: "123AB".
	 */
	public static String convertNumeralSystem(Number originalNumber, int targetSystem) {
		String targetValue = "";

		// Convert value of integer part, from decimal to target system.
		int currentValue = Parser.parseDoubleToInt(originalNumber.getValueInDecimalSystem());
		if (currentValue == 0) {
			targetValue = "0";
		}

		while (currentValue != 0) {
			if (currentValue % targetSystem <= 9) {
				targetValue = Parser.parseIntToString(currentValue % targetSystem) + targetValue;
			}
			else {
				char letterFromNumber = Parser.parseIntToChar(currentValue % targetSystem + 55);
				targetValue = Parser.parseCharToString(letterFromNumber) + targetValue;
			}

			currentValue /= targetSystem;
		}

		return targetValue;
	}

	/**
	 * Helper method taking a number (which contains both its value and its numeral system) and converting it into the decimal system.
	 * Example: number is a number with value "1010", and numeral system 2, double value 10 is returned.
	 *
	 * @param number Number to convert (contains number value and its system).
	 * @return Converted value represented in decimal system, example: 1000.
	 */
	public static double convertToDecimalValue(Number number) {
		double valueInDecimal = 0;

		if (number.getNumeralSystem() == 10) {
			valueInDecimal = Parser.parseStringToDouble(number.getValue());
		}
		else {
			double index = 0;

			// Iterating through numbers of original number.
			for (int i = number.getValue().length() - 1; i >= 0; i--) {
				// Establishing value of current character.
				double symbolValue = 0;
				double asciiCode = number.getValue().getBytes(StandardCharsets.US_ASCII)[i];

				// In case of a number.
				if (asciiCode >= 48 && asciiCode <= 57) {
					symbolValue = asciiCode - 48;
				}
				// In case of an upper case letter.
				else if (asciiCode >= 65 && asciiCode <= 90) {
					symbolValue = asciiCode - 55;
				}
				// In case of a lower case letter.
				else if (asciiCode >= 97 && asciiCode <= 122) {
					symbolValue = asciiCode - 87;
				}

				valueInDecimal += symbolValue * Math.pow(Parser.parseIntToDouble(number.getNumeralSystem()), index);
				index++;
			}
		}

		return valueInDecimal;
	}
}
