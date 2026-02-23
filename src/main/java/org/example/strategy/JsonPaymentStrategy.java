package org.example.strategy;


import org.example.dto.PaymentRequestDto;
import org.example.service.PaymentService;

public class JsonPaymentStrategy implements PaymentService {

    @Override
    public void processPayment(PaymentRequestDto requestDto) {
        String json = "{ " +
                "\"sender\": \"" + requestDto.getSender() + "\"," +
                "\"receiver\": \"" + requestDto.getReceiver() + "\"," +
                "\"amount\": " + requestDto.getAmount() +
                "}";

        System.out.println("Sending JSON to core banking: " + json);
    }
}
