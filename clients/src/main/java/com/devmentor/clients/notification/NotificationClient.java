package com.devmentor.clients.notification;

import com.devmentor.clients.notification.model.request.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notification")
public interface NotificationClient {
  @PostMapping("api/v1/notifications")
   void sendNotification(NotificationRequest notificationRequest);
}
