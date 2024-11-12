package com.devmentor.customer.service.impl;

import com.devmentor.customer.model.request.CustomerRegistrationRequest;
import com.devmentor.customer.persistence.entity.Customer;
import com.devmentor.customer.persistence.repository.CustomerRepository;
import com.devmentor.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerRegistrationImpl implements CustomerService {
  private final CustomerRepository customerRepository;

  @Override
  public void registerCustomer(CustomerRegistrationRequest request) {
    Customer customer = new Customer();
    BeanUtils.copyProperties(request, customer);
    customerRepository.saveAndFlush(customer);
  }
}
