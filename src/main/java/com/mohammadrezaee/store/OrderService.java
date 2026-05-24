package com.mohammadrezaee.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//adding this annotation makes spring boot know this class when he wants to make BEAN
// component and service annotation are alias
//@Service
public class OrderService {

    private PaymentService paymentService;

    //usually springs uses the default construction which is the constructer with no arguments
    //if we have multiple construction, we need to add another annotation to tell spring-boot which construction needs to be used.
    //@Autowired
    //another way to tell spring which class to choose for wiring dependencies is @Qualifier
    //then we need to add this name to a Service annotation in a class (PayPal class in this case)
//    public OrderService(@Qualifier("paypal") PaymentService paymentService){
//        this.paymentService = paymentService;
//    }
    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    //we can hook to different stage of Bean's creation and do some operation, for example here after executing of contructur we do some initialization
    //the name of the function does not matter
    @PostConstruct //this annotation means the function will be executed after executing of constructer in this BEAN
    public void init(){}

    @PreDestroy //here it means before destroying this BEAN, this method will be executed
    public void cleanup(){}

    public void placeOrder(){
        paymentService.processPayment(10);
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
