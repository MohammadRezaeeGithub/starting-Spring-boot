package com.mohammadrezaee.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        //we let spring boot do the job for us(creating the object and injecting all dependencies wiring)
        var orderService = context.getBean(OrderService.class);
        orderService.placeOrder();
    }

}
