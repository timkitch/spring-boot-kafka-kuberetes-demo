package com.jci.spring.springbootkafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${jci.kafka-topic}")
    private String topicName;

    public void sendMessage(String message) {
        logger.info(String.format("Sending message -> %s", message));
        this.kafkaTemplate.send(topicName, message);
        logger.info(String.format("Message sent -> %s", message));
    }
}