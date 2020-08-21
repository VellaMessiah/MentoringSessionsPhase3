package com.mentoringsessions.session1;

import com.mentoringsessions.session1.Entities.Customer;
import com.mentoringsessions.session1.Services.CustomerService;
import com.mentoringsessions.session1.Services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mentoringsessions.session1")
public class Session1Application implements CommandLineRunner {
    private CustomerService customerService;

    @Autowired
    public Session1Application(CustomerService customerService){
        this.customerService=customerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Session1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customerService.addCustomer(new Customer("1","Prajjwal",70000));
        customerService.addCustomer(new Customer("2","Tyler",80000));
        customerService.addCustomer(new Customer("3","Durden",90000));

    }
}
