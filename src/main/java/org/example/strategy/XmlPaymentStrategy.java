package org.example.strategy;

import lombok.RequiredArgsConstructor;
import org.example.dto.PaymentRequestDto;
import org.example.service.PaymentService;
import org.example.system.PaymentSystem;

@RequiredArgsConstructor
public class XmlPaymentStrategy implements PaymentService {
    private final PaymentSystem paymentSystem;
    @Override
    public void processPayment(PaymentRequestDto requestDto) {
        if (requestDto.getSender() == null || requestDto.getSender().isBlank()) {
            throw new IllegalArgumentException("Sender cannot be null");
        }

        if (requestDto.getReceiver() == null || requestDto.getReceiver().isBlank()) {
            throw new IllegalArgumentException("Receiver cannot be null");
        }

        if (requestDto.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        String xml=convertToXml(requestDto);
        paymentSystem.sendXml(xml);
    }
    private String convertToXml(PaymentRequestDto request) {
        return "<payment>" +
                "<sender>" + request.getSender() + "</sender>" +
                "<receiver>" + request.getReceiver() + "</receiver>" +
                "<amount>" + request.getAmount() + "</amount>" +
                "</payment>";
    }
}
