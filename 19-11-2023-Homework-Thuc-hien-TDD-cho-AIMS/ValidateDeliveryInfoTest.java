import common.exception.InvalidDeliveryInfoException;
import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateDeliveryInfoTest {

    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setup() throws Exception {
        placeOrderController = new PlaceOrderController();
    }

    @Test
    void testValidDeliveryInfo() {
        // Given
        HashMap<String, String> validInfo = new HashMap<>();
        validInfo.put("phone", "0123456789");
        validInfo.put("name", "Picachu");
        validInfo.put("address", "Ha Noi 123 Main Street");

        // Then
        assertDoesNotThrow(() -> placeOrderController.validateDeliveryInfo(validInfo));
    }

    @Test
    void testInvalidPhoneNumber() {
        // Given
        HashMap<String, String> invalidInfo = new HashMap<>();
        invalidInfo.put("phone", "invalid_phone");
        invalidInfo.put("name", "Picachu");
        invalidInfo.put("address", "123 Main Street");

        // Then
        assertThrows(InvalidDeliveryInfoException.class, () -> placeOrderController.validateDeliveryInfo(invalidInfo));
    }

    @Test
    void testInvalidName() {
        // Given
        HashMap<String, String> invalidInfo = new HashMap<>();
        invalidInfo.put("phone", "0123456789");
        invalidInfo.put("name", "123");
        invalidInfo.put("address", "123 Main Street");

        // Then
        assertThrows(InvalidDeliveryInfoException.class, () -> placeOrderController.validateDeliveryInfo(invalidInfo));
    }

    @Test
    void testInvalidAddress() {
        // Given
        HashMap<String, String> invalidInfo = new HashMap<>();
        invalidInfo.put("phone", "0123456789");
        invalidInfo.put("name", "Picachu");
        invalidInfo.put("address", "@#InvalidAddress");

        // Then
        assertThrows(InvalidDeliveryInfoException.class, () -> placeOrderController.validateDeliveryInfo(invalidInfo));
    }

    @Test
    void testInvalidCombinedInfo() {
        // Given
        HashMap<String, String> invalidInfo = new HashMap<>();
        invalidInfo.put("phone", "invalid_phone");
        invalidInfo.put("name", "123");
        invalidInfo.put("address", "@#InvalidAddress");

        // Then
        assertThrows(InvalidDeliveryInfoException.class, () -> placeOrderController.validateDeliveryInfo(invalidInfo));
    }
}
