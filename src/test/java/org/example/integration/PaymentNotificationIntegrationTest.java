package org.example.integration;

import org.example.dto.PaymentRequestDto;
import org.example.service.NotificationService;
import org.example.service.PaymentService;
import org.example.service.mockService.MockNotificationService;
import org.example.service.mockService.MockPaymentService;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class PaymentNotificationIntegrationTest {
    @Test
    void paymentShouldTriggerNotification() {
        NotificationService notificationService = new MockNotificationService();
        PaymentService paymentService = new MockPaymentService(notificationService);
        PaymentRequestDto request = new PaymentRequestDto("Farid", "Revan", 561);

        assertDoesNotThrow(() -> paymentService.processPayment(request));
    }
    @Test
    void paymentShouldTriggerNotificationVerify(){
        NotificationService notificationService = mock(MockNotificationService.class);
        PaymentService paymentService = new MockPaymentService(notificationService);

        PaymentRequestDto request = new PaymentRequestDto("Revan", "Elmir", 450);
        paymentService.processPayment(request);

        verify(notificationService, times(1))
                .sendNotification("Payment of 450.0 processed.");

    }
}
