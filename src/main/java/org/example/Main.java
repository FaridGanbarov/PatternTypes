package org.example;

import org.example.dto.PaymentRequestDto;
import org.example.system.PaymentContext;
import org.example.system.PaymentSystem;
import org.example.util.JsonPaymentStrategy;
import org.example.util.XmlPaymentStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentRequestDto dto=new PaymentRequestDto("Farid", "Ali",1500);
        PaymentContext context = new PaymentContext();
        // Strategy 1
        context.setPaymentService(
                new XmlPaymentStrategy(new PaymentSystem()));
        context.execute(dto);

        // Strategy 2
        context.setPaymentService(
                new JsonPaymentStrategy());
        context.execute(dto);


    }
}