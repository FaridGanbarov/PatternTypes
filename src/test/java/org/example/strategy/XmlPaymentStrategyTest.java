package org.example.strategy;

import org.example.dto.PaymentRequestDto;
import org.example.system.PaymentSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void shouldHandleNullSender(){
        PaymentSystem paymentSystem = new PaymentSystem();
        XmlPaymentStrategy strategy = new XmlPaymentStrategy(paymentSystem);

        PaymentRequestDto request = new PaymentRequestDto(null, "Ali", 400);

        assertDoesNotThrow(() -> strategy.processPayment(request));
    }

    @Test
    void shouldHandleNullReceiver(){
        PaymentSystem paymentSystem = new PaymentSystem();
        XmlPaymentStrategy strategy = new XmlPaymentStrategy(paymentSystem);

        PaymentRequestDto request = new PaymentRequestDto("Farid", null, 700);

        assertDoesNotThrow(() -> strategy.processPayment(request));
    }

    @Test
    void shouldHandleZeroAmount(){
        PaymentSystem paymentSystem = new PaymentSystem();
        XmlPaymentStrategy strategy = new XmlPaymentStrategy(paymentSystem);
        PaymentRequestDto request = new PaymentRequestDto("Farid", "Ali", 0);

        assertDoesNotThrow(() -> strategy.processPayment(request));
    }

    @Test
    void shouldHandleNegativeAmount(){
        PaymentSystem paymentSystem = new PaymentSystem();
        XmlPaymentStrategy strategy = new XmlPaymentStrategy(paymentSystem);
        PaymentRequestDto request = new PaymentRequestDto("Farid", "Ali", -100);

        assertDoesNotThrow(() -> strategy.processPayment(request));
    }

}
