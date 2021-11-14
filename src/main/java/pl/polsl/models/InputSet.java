package pl.polsl.models;

/**
 * Class responsible for storing user input.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class InputSet {
	/**
	 * InputSet's number value.
	 */
	private String numberValue;

	/**
	 * InputSet's original numeral system.
	 */
	private String originalSystem;

	/**
	 * InputSet's target numeral system.
	 */
	private String targetSystem;

	/**
	 * Getter method for number value field.
	 *
	 * @return InputSet's number value.
	 */
	public String getNumberValue() {return numberValue;}

	/**
	 * Getter method for original numeral system field.
	 *
	 * @return InputSet's original numeral system.
	 */
	public String getOriginalSystem() {return originalSystem;}

	/**
	 * Getter method for target numeral system field.
	 *
	 * @return InputSet's target numeral system.
	 */
	public String getTargetSystem() {return targetSystem;}

	/**
	 * Setter method for number value field.
	 *
	 * @param value Number value to set to.
	 */
	public void setNumberValue(String value) {numberValue = value;}

	/**
	 * Setter method for original numeral system  field.
	 *
	 * @param value Original numeral system value to set to.
	 */
	public void setOriginalSystem(String value) {originalSystem = value;}

	/**
	 * Setter method for target numeral system  field.
	 *
	 * @param value Target numeral system value to set to.
	 */
	public void setTargetSystem(String value) {targetSystem = value;}
}
