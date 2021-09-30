package com.offsidegaming.monitoring.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShowMetersDto {
    private Long userId;

    private List<ColdWaterMeterDto> coldWaterMeters;

    private List<GasMeterDto> gasMeters;

    private List<HotWaterMeterDto> hotWaterMeters;
}
