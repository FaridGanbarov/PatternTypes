package org.example.context;

import org.example.dto.PaymentRequestDto;
import org.example.service.PaymentService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentContextTest {

    @Test
    void shouldThrowExceptionWhenStrategyIsNull() {
        PaymentContext context = new PaymentContext();

        PaymentRequestDto request =
                new PaymentRequestDto("Ceyhun", "Murad", 600);

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> context.execute(request)
        );

        assertEquals("Payment strategy not selected!", exception.getMessage());
    }

    @Test
    void shouldExecutePaymentWhenStrategyExists() {
        PaymentService dummyStrategy = request ->
                System.out.println("Test payment executed");

        PaymentContext context = new PaymentContext();
        context.setPaymentService(dummyStrategy);

        PaymentRequestDto request =
                new PaymentRequestDto("Ibrahim", "Farid", 500);

        assertDoesNotThrow(() -> context.execute(request));
    }

    @Test
    void shouldFailOnNullRequest(){
        PaymentService dummyStrategy = request -> {
            if (request == null) throw new IllegalArgumentException("Request cannot be null");
        };

        PaymentContext context = new PaymentContext();
        context.setPaymentService(dummyStrategy);

        assertThrows(IllegalArgumentException.class, () -> context.execute(null));
    }


}
