import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateAddressTest {

    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setup() throws Exception {
        placeOrderController = new PlaceOrderController();
    }

    @ParameterizedTest
    @CsvSource({
            "false, 0123456789",
            "true, Ngo Goc De",
            "false,  ",
            "true, Ngo Bo De",
            "true, Ngo Bo De",
            "true, 012 a378",
            "true, null"
    })
    void test(boolean expected, String address) {
        boolean isValid = placeOrderController.validateAddress(address);
        assertEquals(expected, isValid);
    }
}
