package org.example.strategy;

import org.example.dto.PaymentRequestDto;
import org.example.system.PaymentSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class XmlPaymentStrategyTest {
    @Test
    void shouldProcessPaymentWithoutException() {
        PaymentSystem paymentSystem = new PaymentSystem();
        XmlPaymentStrategy strategy = new XmlPaymentStrategy(paymentSystem);

        PaymentRequestDto request =
                new PaymentRequestDto("Farid", "Ali", 200);

        assertDoesNotThrow(() -> strategy.processPayment(request));
    }

    @Test
    void shouldThrowWhenSenderIsNull() {
        PaymentSystem paymentSystem = new PaymentSystem();
        XmlPaymentStrategy strategy = new XmlPaymentStrategy(paymentSystem);

        PaymentRequestDto request = new PaymentRequestDto(null, "Ali", 400);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> strategy.processPayment(request)
        );

        assertEquals("Sender cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowWhenReceiverIsNull() {
        PaymentSystem paymentSystem = new PaymentSystem();
        XmlPaymentStrategy strategy = new XmlPaymentStrategy(paymentSystem);

        PaymentRequestDto request = new PaymentRequestDto("Farid", null, 700);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> strategy.processPayment(request)
        );

        assertEquals("Receiver cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowWhenAmountIsZero() {
        PaymentSystem paymentSystem = new PaymentSystem();
        XmlPaymentStrategy strategy = new XmlPaymentStrategy(paymentSystem);

        PaymentRequestDto request = new PaymentRequestDto("Farid", "Ali", 0);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> strategy.processPayment(request)
        );

        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    void shouldThrowWhenAmountIsNegative() {
        PaymentSystem paymentSystem = new PaymentSystem();
        XmlPaymentStrategy strategy = new XmlPaymentStrategy(paymentSystem);

        PaymentRequestDto request = new PaymentRequestDto("Farid", "Ali", -100);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> strategy.processPayment(request)
        );

        assertEquals("Amount must be positive", exception.getMessage());
    }

}
