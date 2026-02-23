package org.example.strategy;

import org.example.dto.PaymentRequestDto;
import org.example.system.PaymentSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class JsonPaymentStrategyTest {
    @Test
    void shouldProcessJsonPaymentWithoutException() {
        JsonPaymentStrategy strategy = new JsonPaymentStrategy();

        PaymentRequestDto request =
                new PaymentRequestDto("Farid", "Ali", 400);

        assertDoesNotThrow(() -> strategy.processPayment(request));
    }
}
