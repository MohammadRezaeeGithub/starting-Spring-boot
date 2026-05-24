package com.mohammadrezaee.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


//using this annotation to tell spring that it is for configuring the applicaiton
//we used when we want more control on Beans which is impossible with annotations
@Configuration
public class AppConfig {

    @Value("${payment-gateway}")
    private String paymentGateway;

    //saying this method is for Bean's creation
    @Bean
    public PaymentService stripe(){
        return new StripPaymentService();
    }

    //@Lazy we use this annotation to tell spring to create the Bean for this servic when it is needed
//beacuse spring by default creates all Beans when we run the application
    @Bean
    public PaymentService payPal(){
        return new PayPalPaymentService();
    }

    @Bean
    //@Scope("prototype") means that whenever we call a service,spring make a new instance of it
    // while @Scope("singleton") means spring just make one instance of the class for all the calls
    //we also have REQUEST and SESSION
    public OrderService orderService(){
        if (paymentGateway.equals("paypal")){
            return new OrderService(payPal());
        }
        //in orderService we need a payment service
        return new OrderService(stripe());
    }
}
