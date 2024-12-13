package com.devmentor.notification.rabbitmq;

import com.devmentor.clients.notification.model.request.NotificationRequest;
import com.devmentor.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
  private final NotificationService notificationService;

  @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
  public void consumer(NotificationRequest notificationRequest){
    log.info("Received notification from RabbitMQ: {}", notificationRequest);
    notificationService.send(notificationRequest);  // Assuming NotificationService is responsible for sending notification
  }
}
