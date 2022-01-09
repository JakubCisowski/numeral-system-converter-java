package pl.polsl.models;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Stream;

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
        
         /**
     * Serializes registry to string.
     * @return Registry format "{numberValue},{originalSystem}.{conversionResult}-{targetSystem};".
     */
    public String serToStr() {

        StringBuilder builder = new StringBuilder();
        for (ConversionSet element : setCollection) {
            builder.append(element.getNumberValue()).append(',').append(element.getOriginalSystem()).append('.').append(element.getConversionResult()).append('-').append(element.getTargetSystem()).append(';');
        }
        return builder.toString();
    }
    
     /**
     * Deserializes string to registry.
     * @param ser Serialized string (with registry).
     */
    public void desFromStr(String ser) {
        setCollection.clear();
        while (true) {
            int semicolonIndex = ser.indexOf(';');
            if (semicolonIndex == -1) {
                break;
            }

            String elementSubstring = ser.substring(0, semicolonIndex);
            int commaIndex = elementSubstring.indexOf(',');
            int dotIndex = elementSubstring.indexOf('.');
            int dashIndex = elementSubstring.indexOf('-');

            String first = elementSubstring.substring(0, commaIndex);
            String second = elementSubstring.substring(commaIndex, dotIndex);
            String third = elementSubstring.substring(dotIndex, dashIndex);
            String fourth = elementSubstring.substring(dashIndex + 1);
            addConversionSet(first, second,fourth, third);
            ser = ser.substring(semicolonIndex + 1);
        }

    }

}
