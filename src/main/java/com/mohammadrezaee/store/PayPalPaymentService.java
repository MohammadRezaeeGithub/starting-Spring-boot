package com.mohammadrezaee.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//when there are multiple candidates for wiring the dependencies,we add another annotation to say that this class should be chosen first
//@Primary annotation tell spring boot to use this class when he does wiring
//@Service("paypal")
public class PayPalPaymentService implements PaymentService{

    @Override
    public void processPayment(double amount){
        System.out.println("PAYPAL ");
        System.out.println("Amount : " + amount);
    }
}
