package org.example.service;

import org.example.dto.PaymentRequestDto;

public interface PaymentService {
    void processPayment(PaymentRequestDto requestDto);
}
