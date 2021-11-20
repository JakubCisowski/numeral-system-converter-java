package pl.polsl.models;

/**
 * Class responsible for storing user input and conversion result.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class ConversionSet {
	/**
	 * ConversionSet's number value.
	 */
	private String numberValue;

	/**
	 * ConversionSet's original numeral system.
	 */
	private String originalSystem;

	/**
	 * ConversionSet's target numeral system.
	 */
	private String targetSystem;

	/**
	 * ConversionSet's result of the conversion.
	 */
	private String conversionResult;

	/**
	 * Getter method for number value field.
	 *
	 * @return ConversionSet's number value.
	 */
	public String getNumberValue() {return numberValue;}

	/**
	 * Getter method for original numeral system field.
	 *
	 * @return ConversionSet's original numeral system.
	 */
	public String getOriginalSystem() {return originalSystem;}

	/**
	 * Getter method for target numeral system field.
	 *
	 * @return ConversionSet's target numeral system.
	 */
	public String getTargetSystem() {return targetSystem;}

	/**
	 * Getter method for conversion result field.
	 *
	 * @return ConversionSet's target numeral system.
	 */
	public String getConversionResult() {return conversionResult;}

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

	/**
	 * Setter method for conversion result field.
	 *
	 * @param value Conversion result value to set to.
	 */
	public void setConversionResult(String value) {conversionResult = value;}
}
