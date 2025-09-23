package com.live.kafka.stream.controller;

import com.live.kafka.stream.producer.CarProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarProducer carProducer;

    @PostMapping
    public ResponseEntity<CarDTO> create(@RequestBody @Validated CarDTO carDTO) {
        carProducer.sendMessage(carDTO);
        return ResponseEntity.accepted()
                .body(carDTO);
    }
}
