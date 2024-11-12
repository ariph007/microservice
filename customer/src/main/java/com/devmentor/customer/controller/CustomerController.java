package com.devmentor.customer.controller;

import com.devmentor.customer.model.request.CustomerRegistrationRequest;
import com.devmentor.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping
  public void registerCustomer(@RequestBody CustomerRegistrationRequest request){
    log.info("new customer registration {}", request);
    customerService.registerCustomer(request);  // Assuming CustomerService is responsible for registering customer
  }

}
