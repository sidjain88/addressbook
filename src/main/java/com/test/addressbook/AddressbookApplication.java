package com.test.addressbook;

import com.test.addressbook.service.InputService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AddressbookApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AddressbookApplication.class, args);
        InputService inputService = (InputService) ctx.getBean("inputService");
        inputService.takeInput();

    }

}
