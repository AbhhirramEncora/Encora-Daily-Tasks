package com.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @KafkaListener(topics = "simple-topic", groupId = "simple-group")
    public void listen(String message) {
        System.out.println("📩 Received: " + message);
    }
}
