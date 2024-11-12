package com.devmentor.fraud.service.impl;

import com.devmentor.fraud.persistence.entity.FraudCheckHistory;
import com.devmentor.fraud.persistence.repository.FraudCheckHistoryRepository;
import com.devmentor.fraud.service.FraudCheckHistoryService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FraudCheckHistoryServiceImpl implements FraudCheckHistoryService {

  private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

  @Override
  public Boolean isFraudlentCustomer(Integer customerId) {
    fraudCheckHistoryRepository.saveAndFlush(FraudCheckHistory.builder()
        .customerId(customerId)
        .isFraudster(false)
        .createdAt(LocalDateTime.now())
        .build()
    );
    return false;
  }
}
