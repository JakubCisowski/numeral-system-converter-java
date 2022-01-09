package pl.polsl.models;

import java.nio.charset.StandardCharsets;

/**
 * Validator class, handles all user input validation in the application.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
class Validator {
	/**
	 * Method validating uncompressed user input algorithm parameters.
	 *
	 * @param numberValue    Uncompressed original number value.
	 * @param originalSystem Uncompressed original numeral system.
	 * @param targetSystem   Uncompressed target numeral system.
	 * @throws InvalidParameterException If input parameters are not valid.
	 */
	void validateParameters(String numberValue, String originalSystem, String targetSystem) throws InvalidParameterException {

		if (numberValue == null || originalSystem == null || targetSystem == null) {
			throw new InvalidParameterException("Null input is not allowed");
		}

		// Parameters can't be empty anyways, so no need to check that.
		checkIfNumeralSystemExists(originalSystem);
		checkIfNumeralSystemExists(targetSystem);
		checkIfNumberExistsInGivenSystem(numberValue, originalSystem);
	}

	/**
	 * Method checking whether number exists in given numeral system.
	 *
	 * @param numberValue   Uncompressed number value.
	 * @param systemToCheck Uncompressed numeral system.
	 * @throws InvalidParameterException If input parameters are not valid.
	 */
	private void checkIfNumberExistsInGivenSystem(String numberValue, String systemToCheck) throws InvalidParameterException {
		int systemValue =  Integer.parseInt(systemToCheck);

		for (int i = 0; i < numberValue.length(); i++) {
			double asciiCode = numberValue.getBytes(StandardCharsets.US_ASCII)[i];

			// In case of a number
			if (asciiCode >= 48 && asciiCode <= 57 && systemValue <= asciiCode - 48) {
				throw new InvalidParameterException(numberValue + " is not a valid value in numeral system - " + systemToCheck);
			}
			// In case of an upper case letter
			else if (asciiCode >= 65 && asciiCode <= 90 && systemValue <= asciiCode - 55) {
				throw new InvalidParameterException(numberValue + " is not a valid value in numeral system - " + systemToCheck);
			}
			// In case of a lower case letter
			else if (asciiCode >= 97 && asciiCode <= 122 && systemValue <= asciiCode - 87) {
				throw new InvalidParameterException(numberValue + " is not a valid value in numeral system - " + systemToCheck);
			}
			// In case of other character
			else if (asciiCode < 48 || (asciiCode > 57 && asciiCode < 65) || (asciiCode > 90 && asciiCode < 97) || asciiCode > 122) {
				throw new InvalidParameterException(numberValue + " is not a valid value in numeral system - " + systemToCheck);
			}
		}
	}

	/**
	 * Method checking whether given numeral system exists.
	 *
	 * @param numeralSystem Uncompressed original numeral system.
	 * @throws InvalidParameterException If input parameters are not valid.
	 */
	private void checkIfNumeralSystemExists(String numeralSystem) throws InvalidParameterException {
		checkIfNumeralSystemIsNumeric(numeralSystem);

		int systemValue = Integer.parseInt(numeralSystem);

		if (!(systemValue >= 2 && systemValue <= 36)) {
			throw new InvalidParameterException(numeralSystem + " is not a valid numeral system - min:2, max:36.");
		}
	}

	/**
	 * Method checking whether given numeral system contains only numeric values.
	 *
	 * @param numeralSystem Uncompressed original numeral system.
	 * @throws InvalidParameterException If input parameters are not valid.
	 */
	private void checkIfNumeralSystemIsNumeric(String numeralSystem) throws InvalidParameterException {
		try {
			Double.parseDouble(numeralSystem);
		} catch (NumberFormatException e) {
			throw new InvalidParameterException(numeralSystem + " is not a valid numeral system - invalid characters - min:2, max:36.");
		}
	}
}
