package pl.polsl.models;

/**
 * Parser class, handles all type-to-type parsing in the application.
 * @author Jakub Cisowski
 * @version 1.0
 */
public class Parser
{
	/**
	 * Method parsing value from type String into type int.
	 *
	 * @param originalValue  Value before parsing.
	 * @return Value after parsing.
	 */
	public static int parseStringToInt(String originalValue)
	{
		return Integer.parseInt(originalValue);
	}

	/**
	 * Method parsing value from type String into type double.
	 *
	 * @param originalValue  Value before parsing.
	 * @return Value after parsing.
	 */
	public static double parseStringToDouble(String originalValue)
	{
		return Double.parseDouble(originalValue);
	}

	/**
	 * Method parsing value from type int into type double.
	 *
	 * @param originalValue  Value before parsing.
	 * @return Value after parsing.
	 */
	public static double parseIntToDouble(int originalValue)
	{
		return originalValue;
	}

	/**
	 * Method parsing value from type double into type int.
	 *
	 * @param originalValue  Value before parsing.
	 * @return Value after parsing.
	 */
	public static int parseDoubleToInt(double originalValue)
	{
		return (int)Math.round(originalValue);
	}

	/**
	 * Method parsing value from type int into type string.
	 *
	 * @param originalValue  Value before parsing.
	 * @return Value after parsing.
	 */
	public static String parseIntToString(int originalValue)
	{
		return String.valueOf(originalValue);
	}

	/**
	 * Method parsing value from type char into type string.
	 *
	 * @param originalValue  Value before parsing.
	 * @return Value after parsing.
	 */
	public static String parseCharToString(char originalValue)
	{
		return String.valueOf(originalValue);
	}

	/**
	 * Method parsing value from type int into type char.
	 *
	 * @param originalValue  Value before parsing.
	 * @return Value after parsing.
	 */
	public static char parseIntToChar(int originalValue)
	{
		return (char)originalValue;
	}
}
