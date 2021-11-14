import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.polsl.models.Validator;

/**
 * Class containing tests of the user input validator.
 * @author Jakub Cisowski
 * @version 1.0
 */
public class ValidationTest {

	private Validator validator;

	@BeforeEach
	void setUp() {
		validator = new Validator();
	}

	@ParameterizedTest
	@CsvSource({"10,2,5", "40,40,40"})
	void invalidDataThrowsInvalidParameterException(String inputNumberValue, String inputOriginalSystem, String inputTargetSystem) {

	}

	@ParameterizedTest
	@CsvSource({"15,10,2", "435,35,2"})
	void validDataDoesNotThrowAnyException(String inputOriginalSystem, String inputTargetSystem) {

	}
}
