package com.live.kafka.stream.controller;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class CarDTO {

    @NonNull
    private String id;
    @NonNull
    private String model;
    @NonNull
    private String color;
}
