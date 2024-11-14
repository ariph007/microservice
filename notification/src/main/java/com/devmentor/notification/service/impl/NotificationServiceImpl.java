package com.devmentor.notification.service.impl;

import com.devmentor.clients.notification.model.request.NotificationRequest;
import com.devmentor.notification.persistence.entity.Notification;
import com.devmentor.notification.persistence.repository.NotificationRepository;
import com.devmentor.notification.service.NotificationService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {
  private final NotificationRepository notificationrepository;

  @Override
  public void send(NotificationRequest notificationRequest) {
    notificationrepository.saveAndFlush(Notification.builder()
        .toCustomerEmaill(notificationRequest.getCustomerEmail())
        .toCustomerId(notificationRequest.getCustomerId())
        .sender("DevMentor")
        .message(notificationRequest.getMessage())
        .sentAt(LocalDateTime.now())
        .build()
    );
  }
}
