import static org.junit.jupiter.api.Assertions.*;

import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatePhoneNumberTest {

	private PlaceOrderController placeOrderController;

	@BeforeEach
	void setup() throws Exception {
		placeOrderController = new PlaceOrderController();
	}

	@Test
	void testValidPhoneNumber() {
		String validPhoneNumber = "0123456789";

		boolean isValid = placeOrderController.validatePhoneNumber(validPhoneNumber);

		assertTrue(isValid);
	}

	@Test
	void testInvalidShortPhoneNumber() {
		String invalidPhoneNumber = "01234";

		boolean isValid = placeOrderController.validatePhoneNumber(invalidPhoneNumber);

		assertFalse(isValid);
	}

	@ParameterizedTest
	@CsvSource({
			"true, 9981756384",
			"false, 98765",
			"false, a1234567890",
			"false, 1234567890"
	})
	void test(boolean expected, String phoneNumber) {
		boolean isValid = placeOrderController.validatePhoneNumber(phoneNumber);
		assertEquals(expected, isValid);
	}
}

