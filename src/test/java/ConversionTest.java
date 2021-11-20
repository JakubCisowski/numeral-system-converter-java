
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.polsl.models.Converter;
import pl.polsl.models.Number;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Class containing tests of the numeral system conversion algorithm.
 * @author Jakub Cisowski
 * @version 1.0
 */
public class ConversionTest {
	/**
	 * Converter for unit tests usage.
	 */
	private Converter converter;

	/**
	 * Number for unit tests usage.
	 */
	private Number number;

	/**
	 * Setup function which creates new converter and number for unit tests usage.
	 */
	@BeforeEach
	void setUp() {
		converter = new Converter();
		number = new Number("15",10);
	}

	/**
	 * Parametrized test, checks if conversion works for valid input.
	 * Invalid input is impossible, because input is validated before converting.
	 * Conversion result should be as expected and conversion should not throw any exceptions.
	 */
	@ParameterizedTest
	@CsvSource({"15,10,2,1111", "A2,14,33,4A", "Z,36,2,100011", "11001001,2,36,5L", "AA,11,25,4K"})
	void testNumeralSystemConversion(String originalValue, int originalSystem, int targetSystem, String expected) {
		try{
			number = new Number(originalValue,originalSystem);
			String conversionResult = converter.convertNumeralSystem(number,targetSystem);

			if(!Objects.equals(conversionResult, expected))
			{
				fail("Unexpected conversion result.");
			}
		}
		catch (Exception e)
		{
			fail("Conversion should not throw any exceptions.");
		}
	}
}
