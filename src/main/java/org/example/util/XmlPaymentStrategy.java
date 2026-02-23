package org.example.util;

import lombok.RequiredArgsConstructor;
import org.example.dto.PaymentRequestDto;
import org.example.service.PaymentService;
import org.example.system.PaymentSystem;

@RequiredArgsConstructor
public class XmlPaymentStrategy implements PaymentService {
    private final PaymentSystem paymentSystem;
    @Override
    public void processPayment(PaymentRequestDto requestDto) {
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
