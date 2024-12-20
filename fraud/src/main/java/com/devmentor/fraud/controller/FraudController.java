package com.devmentor.fraud.controller;

import com.devmentor.clients.fraud.model.response.FraudCheckResponse;
import com.devmentor.fraud.service.FraudCheckHistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudController {
  private final FraudCheckHistoryService fraudCheckHistoryService;

  @GetMapping(path = "{customerId}")
  public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
    Boolean isFraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
    log.info("fraud check request for customer {}" + customerId);
    return new FraudCheckResponse(isFraudulentCustomer);
  }
}
