package com.live.kafka.stream.consumer;

import com.live.kafka.stream.controller.CarDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CarConsumer {

    private static final Logger log = LoggerFactory.getLogger(CarConsumer.class);

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "carKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, CarDTO> carDTOConsumerRecord) {
        log.info("Partition: {}, Value: {}", carDTOConsumerRecord.partition(), carDTOConsumerRecord.value());
    }
}
