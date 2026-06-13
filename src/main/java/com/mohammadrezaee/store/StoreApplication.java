package com.mohammadrezaee.store;

import com.mohammadrezaee.store.entities.Address;
import com.mohammadrezaee.store.entities.Tag;
import com.mohammadrezaee.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        //we let spring boot do the job for us(creating the object and injecting all dependencies wiring)
        var user = User.builder()
                .name("Mohammad")
                .email("mohammad@gmail.com")
                .password("123456")
                .build();

        user.addTag("tag1");
        System.out.println(user);
    }

}
