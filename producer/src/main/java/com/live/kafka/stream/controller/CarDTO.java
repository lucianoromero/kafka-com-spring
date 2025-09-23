package com.live.kafka.stream.controller;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    @NonNull
    private String id;
    @NonNull
    private String model;
    @NonNull
    private String color;
}
