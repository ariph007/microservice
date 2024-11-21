package com.devmentor.notification.config;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {
  @Getter
  @Value("${spring.rabbitmq.template.exchange}")
  private String internalExchange;

  @Getter
  @Value("${spring.rabbitmq.template.routing-key}")
  private String internalNotificationRoutingKey;

  @Getter
  @Value("${spring.rabbitmq.template.default-receive-queue}")
  private String notificationQueue;


  @Bean
  public TopicExchange internalTopicExchange(){
    return new TopicExchange(this.internalExchange);
  }

  @Bean
  public Queue notificationQueue(){
    return new Queue(this.notificationQueue);
  }

  @Bean
  public Binding internalToNotificationBinding(){
    return BindingBuilder
        .bind(notificationQueue())
        .to(internalTopicExchange())
        .with(this.internalNotificationRoutingKey);
  }

}
