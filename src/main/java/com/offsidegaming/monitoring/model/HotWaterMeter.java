package com.offsidegaming.monitoring.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.offsidegaming.monitoring.dto.GasMeterDto;
import com.offsidegaming.monitoring.dto.HotWaterMeterDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class HotWaterMeter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private Double value;

    private LocalDate dateOfMeasurement;

    public HotWaterMeterDto toDto(){
        HotWaterMeterDto hotWaterMeterDto = new HotWaterMeterDto();
        hotWaterMeterDto.setDateOfMeasurement(this.dateOfMeasurement);
        hotWaterMeterDto.setValue(this.value);
        return hotWaterMeterDto;
    }

    public static HotWaterMeter toEntity(HotWaterMeterDto hotWaterMeterDto, User user){
        HotWaterMeter hotWaterMeter = new HotWaterMeter();
        hotWaterMeter.user = user;
        hotWaterMeter.value = hotWaterMeterDto.getValue();
        hotWaterMeter.dateOfMeasurement = hotWaterMeterDto.getDateOfMeasurement();
        return hotWaterMeter;
    }
}
