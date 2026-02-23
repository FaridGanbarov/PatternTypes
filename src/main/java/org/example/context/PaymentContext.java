package org.example.context;

import lombok.Setter;
import org.example.dto.PaymentRequestDto;
import org.example.service.PaymentService;

@Setter
public class PaymentContext {
    private PaymentService paymentService;

    public void execute(PaymentRequestDto dto) {

        if (paymentService == null) {
            throw new IllegalStateException("Payment strategy not selected!");
        }

        paymentService.processPayment(dto);
    }
}
