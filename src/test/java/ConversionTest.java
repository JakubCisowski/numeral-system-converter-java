
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.polsl.models.Converter;
import pl.polsl.models.InvalidParameterException;
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
	 * Setup function which creates new converter and number for unit tests usage.
	 */
	@BeforeEach
	void setUp() {
		converter = new Converter();
	}

	/**
	 * Parametrized test, checks if conversion works for valid input.
	 * Invalid input is impossible, because input is validated before converting.
	 * Conversion result should be as expected and conversion should not throw any exceptions.
	 */
	@ParameterizedTest
	@CsvSource({"15,10,2,1111", "A2,14,33,4A", "Z,36,2,100011", "11001001,2,36,5L", "AA,11,25,4K"})
	void testNumeralSystemConversion(String originalValue, String originalSystem, String targetSystem, String expected) {
		try{
			String conversionResult = converter.convertNumeralSystem(originalValue,originalSystem,targetSystem);

			if(!Objects.equals(conversionResult, expected)) {
				fail("Unexpected conversion result.");
			}
		}
		catch (Exception e) {
			fail("Conversion should not throw any exceptions.");
		}
	}

	/**
	 * Parametrized test, checks if validation throws InvalidParameterException when validating invalid input.
	 */
	@ParameterizedTest
	@CsvSource({"30,2,5", "40,40,40", "0,0,0", "1,5,37", "5,1,10", "5,0,3", "A,10,12", ",,", " , , "})
	void invalidDataThrowsInvalidParameterException(String inputNumberValue, String inputOriginalSystem, String inputTargetSystem) {
		try{
			converter.convertNumeralSystem(inputNumberValue, inputOriginalSystem, inputTargetSystem);
			fail("Validating INVALID input data did not throw InvalidParameterException.");
		}
		catch (InvalidParameterException e) {
			return;
		}
	}

	/**
	 * Test that checks if validation throws InvalidParameterException when validating null input.
	 */
	@Test
	void nullDataThrowsInvalidParameterException() {
		try{
			converter.convertNumeralSystem(null, null, null);
			fail("Validating NULL input data did not throw InvalidParameterException.");
		}
		catch (InvalidParameterException e) {
			return;
		}
	}

	/**
	 * Parametrized test, checks if validation doesn't throw InvalidParameterException when validating valid input.
	 */
	@ParameterizedTest
	@CsvSource({"15,10,2", "435,35,2", "A,11,36", "Z,36,2"})
	void validDataDoesNotThrowAnyException(String inputNumberValue, String inputOriginalSystem, String inputTargetSystem) {
		try{
			converter.convertNumeralSystem(inputNumberValue, inputOriginalSystem, inputTargetSystem);
		}
		catch (InvalidParameterException e) {
			fail("Validating VALID input data threw InvalidParameterException.");
		}
	}
}
