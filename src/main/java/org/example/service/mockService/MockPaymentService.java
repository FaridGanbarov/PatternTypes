package org.example.service.mockService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dto.PaymentRequestDto;
import org.example.service.NotificationService;
import org.example.service.PaymentService;

@AllArgsConstructor
public class MockPaymentService implements PaymentService {
    private final NotificationService notificationService;

    @Override
    public void processPayment(PaymentRequestDto requestDto) {
        System.out.println("MockPaymentService: processing payment " + requestDto.getAmount());
        notificationService.sendNotification("Payment of " + requestDto.getAmount() + " processed.");
    }
}
