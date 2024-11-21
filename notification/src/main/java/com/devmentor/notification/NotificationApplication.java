package com.devmentor.notification;

import com.devmentor.amqp.RabbitMQMessageProducer;
import com.devmentor.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(
    scanBasePackages = {
        "com.devmentor.notification",
        "com.devmentor.amqp"
    }
)
@EnableFeignClients(
    basePackages = "com.devmentor.clients"
)
public class NotificationApplication {

  public static void main(String[] args) {
    SpringApplication.run(NotificationApplication.class, args);
  }

//  @Bean
//  CommandLineRunner commandLineRunner(
//      RabbitMQMessageProducer producer,
//      NotificationConfig notificationConfig
//  ) {
//    return args -> {
//      producer.publish(new Person("Eko", 23), notificationConfig.getInternalExchange(),
//          notificationConfig.getInternalNotificationRoutingKey());
//
//
//    };
//  }
//  record Person(String name, int age){}
}
