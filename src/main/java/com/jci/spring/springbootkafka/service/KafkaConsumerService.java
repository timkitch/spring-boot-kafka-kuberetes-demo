package com.jci.spring.springbootkafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
  private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

  @KafkaListener(topics = "${jci.kafka-topic}", groupId = "${jci.kafka-group-id")
  public void consume(String message) {
    logger.info(String.format("Message recieved -> %s", message));
  }
}
