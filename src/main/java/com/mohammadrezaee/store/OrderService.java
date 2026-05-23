package com.mohammadrezaee.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//adding this annotation makes spring boot know this class when he wants to make BEAN
// component and service annotation are alias
@Service
public class OrderService {

    private PaymentService paymentService;

    //usually springs uses the default construction which is the constructer with no arguments
    //if we have multiple construction, we need to add another annotation to tell spring-boot which construction needs to be used.
    //@Autowired
    //another way to tell spring which class to choose for wiring dependencies is @Qualifier
    //then we need to add this name to a Service annotation in a class (PayPal class in this case)
    public OrderService(@Qualifier("paypal") PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        paymentService.processPayment(10);
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
