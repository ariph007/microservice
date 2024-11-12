package com.devmentor.customer.service;

import com.devmentor.customer.model.request.CustomerRegistrationRequest;

public interface CustomerService {
  void registerCustomer(CustomerRegistrationRequest request);
}
