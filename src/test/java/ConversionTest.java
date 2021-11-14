
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.polsl.models.Converter;
import pl.polsl.models.Number;

/**
 * Class containing tests of the numeral system conversion algorithm.
 * @author Jakub Cisowski
 * @version 1.0
 */
public class ConversionTest {
	private Converter converter;
	private Number number;

	@BeforeEach
	void setUp() {
		converter = new Converter();
		number = new Number("15",10);
	}

	@ParameterizedTest
	@CsvSource({"15,10,2,1111", "A2,14,33,4A"})
	void testNumeralSystemConversion(String originalValue, int originalSystem, int targetSystem, String expected) {

	}

	@ParameterizedTest
	@CsvSource({"1111,2,15", "BC,15,177"})
	void testConversionToDecimalSystem(String originalValue, int originalSystem, String expected) {

	}

	@ParameterizedTest
	@CsvSource({"1011,2,11", "1337,9,1006"})
	void testGettingValueInDecimalSystem(String originalValue, int originalSystem, String expected) {

	}
}
