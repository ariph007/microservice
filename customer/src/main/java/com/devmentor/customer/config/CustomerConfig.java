package com.devmentor.customer.config;

import feign.Capability;
import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

  @LoadBalanced
  @Bean
  public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  public Capability capability(final MeterRegistry registry) {
    return new MicrometerCapability(registry);
  }


}
