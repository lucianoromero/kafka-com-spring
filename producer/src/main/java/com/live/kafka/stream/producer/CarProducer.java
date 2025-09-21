package com.live.kafka.stream.producer;

import com.live.kafka.stream.controller.CarDTO;
import com.live.kafka.stream.exception.ProducerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CarProducer {

    private static final Logger logger = LoggerFactory.getLogger(CarProducer.class);

    private final String topic;
    private final KafkaTemplate<String, CarDTO> kafkaTemplate;

    public CarProducer(@Value("${topic.name}") String topic, KafkaTemplate<String, CarDTO> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CarDTO carDTO) {
        kafkaTemplate.send(topic, carDTO.getId(), carDTO)
                .thenAccept(result -> logger.info("Message sent successfully to topic {}: {}", topic, carDTO))
                .exceptionally(failure -> {
                    logger.error("Failed to send message to topic {}: {}", topic, carDTO, failure);
                    throw new ProducerException("Failed to send message to topic " + topic, failure);
                });
    }
}
