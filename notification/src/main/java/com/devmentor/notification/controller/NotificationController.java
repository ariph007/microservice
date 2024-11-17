package com.devmentor.notification.controller;

import com.devmentor.clients.notification.model.request.NotificationRequest;
import com.devmentor.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
@Slf4j
public class NotificationController {
  private final NotificationService notificationService;


  @PostMapping("/notifications")
  void sendNotification(@RequestBody NotificationRequest notificationRequest) {
    log.info("Notification for {}" + notificationRequest.getCustomerEmail());
    notificationService.send(notificationRequest);

  }
}
