import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.polsl.models.InvalidParameterException;
import pl.polsl.models.Validator;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing tests of the user input validator.
 * @author Jakub Cisowski
 * @version 1.0
 */
public class ValidationTest {
	/**
	 * Validator for unit tests usage.
	 */
	private Validator validator;

	/**
	 * Setup function which creates new converter and number for unit tests usage.
	 */
	@BeforeEach
	void setUp() {
		validator = new Validator();
	}

	/**
	 * Parametrized test, checks if validation throws InvalidParameterException when validating invalid input.
	 */
	@ParameterizedTest
	@CsvSource({"30,2,5", "40,40,40", "0,0,0", "1,5,37", "5,1,10", "5,0,3", "A,10,12", ",,", " , , "})
	void invalidDataThrowsInvalidParameterException(String inputNumberValue, String inputOriginalSystem, String inputTargetSystem) {
		try{
			validator.validateParameters(inputNumberValue, inputOriginalSystem, inputTargetSystem);
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
			validator.validateParameters(null, null, null);
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
			validator.validateParameters(inputNumberValue, inputOriginalSystem, inputTargetSystem);
		}
		catch (InvalidParameterException e) {
			fail("Validating VALID input data threw InvalidParameterException.");
		}
	}
}
