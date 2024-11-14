package com.devmentor.notification.service;

import com.devmentor.clients.notification.model.request.NotificationRequest;

public interface NotificationService {
  void send(NotificationRequest notificationRequest);

}
