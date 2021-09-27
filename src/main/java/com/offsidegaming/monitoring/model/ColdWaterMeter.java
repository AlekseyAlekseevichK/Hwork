package com.offsidegaming.monitoring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.offsidegaming.monitoring.dto.ColdWaterMeterDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class ColdWaterMeter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private Double value;

    private LocalDate dateOfMeasurement;

    public ColdWaterMeterDto toDto(){
        ColdWaterMeterDto coldWaterMeterDto = new ColdWaterMeterDto();
        coldWaterMeterDto.setDateOfMeasurement(this.dateOfMeasurement);
        coldWaterMeterDto.setValue(this.value);
        return coldWaterMeterDto;
    }

    public static ColdWaterMeter toEntity(ColdWaterMeterDto coldWaterMeterDto, User user){
        ColdWaterMeter coldWaterMeter = new ColdWaterMeter();
        coldWaterMeter.user = user;
        coldWaterMeter.value = coldWaterMeterDto.getValue();
        coldWaterMeter.dateOfMeasurement = coldWaterMeterDto.getDateOfMeasurement();
        return coldWaterMeter;
    }
}
