import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateNameTest {

    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setup() throws Exception {
        placeOrderController = new PlaceOrderController();
    }

    @ParameterizedTest
    @CsvSource({
            "false, 0123456789",
            "true, Duc Manh",
            "false,  ",
            "false, 12 Van Hien",
            "true, null",
            "false, John_Doe",
            "false, Mary@Smith",
            "false, John Smith Jr."
    })
    void testName(boolean expected, String name) {
        boolean isValid = placeOrderController.validateName(name);
        assertEquals(expected, isValid);
    }
}
