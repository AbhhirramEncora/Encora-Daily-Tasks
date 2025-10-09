package com.example.producer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private static final String TOPIC = "simple-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    public String sendMessage() {
        kafkaTemplate.send(TOPIC, "Hello Kafka 👋");
        return "✅ Message sent!";
    }
}

