package com.offsidegaming.monitoring.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ColdWaterMeterDto {
    private Double value;
    private LocalDate dateOfMeasurement;
}
