package pl.polsl.models;

import pl.polsl.views.Output;

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
	private List<ConversionSet> setCollection;

	/**
	 * Class constructor.
	 */
	public Registry()
	{
		setCollection = new ArrayList<>();
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
	/**
	 * Method for displaying collection of conversion sets to console.
	 * */
	public void showRegistry()
	{
		Output output = new Output();

		output.showStringConsole("REGISTRY RECORDS:", "---");

		for (ConversionSet set : setCollection)
		{
			output.showStringConsole(set.getNumberValue() + "(" + set.getOriginalSystem() + ") = " + set.getConversionResult() + "(" + set.getTargetSystem() + ")");
		}
	}

}
