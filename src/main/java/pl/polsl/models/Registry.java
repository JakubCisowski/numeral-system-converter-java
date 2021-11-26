package pl.polsl.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for keeping track of all conversions and their results.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class Registry {
	/**
	 * Conversion set collection.
	 */
	private final List<ConversionSet> setCollection;

	/**
	 * Class constructor.
	 */
	public Registry()
	{
		setCollection = new ArrayList<>();
	}

	/**
	 * Getter method for Registry field.
	 *
	 * @return Number's value.
	 */
	public List<ConversionSet> getRegistry()
	{
		return setCollection;
	}

	/**
	 * Method for adding a new conversion set to the registry.
	 * @param numberValue ConversionSet's number value.
	 * @param originalSystem ConversionSet's original numeral system.
	 * @param targetSystem ConversionSet's target numeral system.
	 * @param conversionResult ConversionSet's result of the conversion.
	 */
	public void addConversionSet(String numberValue, String originalSystem, String targetSystem, String conversionResult){
		ConversionSet conversionSet = new ConversionSet();
		conversionSet.setNumberValue(numberValue);
		conversionSet.setOriginalSystem(originalSystem);
		conversionSet.setTargetSystem(targetSystem);
		conversionSet.setConversionResult(conversionResult);

		setCollection.add(conversionSet);
	}

}
