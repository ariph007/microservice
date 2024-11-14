package com.devmentor.customer.service.impl;

import com.devmentor.clients.fraud.FraudClient;
import com.devmentor.clients.fraud.model.response.FraudCheckResponse;
import com.devmentor.clients.notification.NotificationClient;
import com.devmentor.clients.notification.model.request.NotificationRequest;
import com.devmentor.customer.model.request.CustomerRegistrationRequest;
import com.devmentor.customer.persistence.entity.Customer;
import com.devmentor.customer.persistence.repository.CustomerRepository;
import com.devmentor.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;
  private final FraudClient fraudClient;
  private final NotificationClient notificationClient;


  @Override
  public void registerCustomer(CustomerRegistrationRequest request) {
    Customer customer = new Customer();
    BeanUtils.copyProperties(request, customer);

    //! check if fraudster
    Customer savedCustomer = customerRepository.saveAndFlush(customer);
//    FraudCheckResponse response = restTemplate.getForObject(
//        "http://FRAUD/api/v1/fraud-check/{customerId}",
//        FraudCheckResponse.class,
//        savedCustomer.getId()
//    );

    FraudCheckResponse response = fraudClient.isFraudster(savedCustomer.getId());

    assert response != null;
    if (response.getIsFraud()) {
      throw new IllegalStateException("Customer is fraudulent");
    }

    //! send notification
    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setCustomerId(savedCustomer.getId());
    notificationRequest.setCustomerEmail(savedCustomer.getEmail());
    notificationRequest.setMessage(String.format("Hi %s, welcome to Devmentor...", savedCustomer.getFirstName()));
    notificationClient.sendNotification(notificationRequest);

  }
}
