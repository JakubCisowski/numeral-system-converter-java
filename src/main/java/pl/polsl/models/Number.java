package pl.polsl.models;

/**
 * Number model, represents both value and it numeral system.
 * @author Jakub Cisowski
 * @version 1.0
 */
public class Number
{
	/**
	 * Number's value.
	 */
	private final String value;
	/**
	 * Number's numeral system.
	 */
	private final int numeralSystem;

	/**
	 * Class constructor.
	 *
	 * @param value Number's value.
	 * @param numeralSystem Number's numeral system.
	 */
	public Number(String value, int numeralSystem)
	{
		this.value = value;
		this.numeralSystem = numeralSystem;
	}

	/**
	 * Getter method for value field.
	 *
	 * @return Number's value.
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * Getter method for numeral system field.
	 *
	 * @return Number's numeral system.
	 */
	public int getNumeralSystem()
	{
		return numeralSystem;
	}

	/**
	 * Method calculating number's value in decimal system.
	 *
	 * @return Number's value in decimal system.
	 */
	public double getValueInDecimalSystem()
	{
		return Converter.convertToDecimalValue(this);
	}

}
