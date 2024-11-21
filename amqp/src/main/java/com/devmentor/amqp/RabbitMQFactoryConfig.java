package com.devmentor.amqp;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFactoryConfig {


  @Bean
  ConnectionFactory connectionFactory(){
    CachingConnectionFactory factory = new CachingConnectionFactory();
    factory.setHost("localhost");
    factory.setUsername("guest");
    factory.setPassword("guest");
    return factory;
  }


}
