package com.offsidegaming.monitoring.dto;

import lombok.Data;

@Data
public class SaveMetersDto {
    private Long userId;
    private ColdWaterMeterDto coldWaterMeter;
    private GasMeterDto gasMeter;
    private HotWaterMeterDto hotWaterMeter;
}
