package com.offsidegaming.monitoring.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GasMeterDto {
    private Double value;
    private LocalDate dateOfMeasurement;
}
