package com.devmentor.customer;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
    scanBasePackages = {
        "com.devmentor.customer",
        "com.devmentor.amqp"
    }
)
@EnableFeignClients(
    basePackages = "com.devmentor.clients"
)
public class CustomerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
