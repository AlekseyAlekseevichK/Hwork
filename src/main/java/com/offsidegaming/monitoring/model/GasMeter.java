package com.offsidegaming.monitoring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.offsidegaming.monitoring.dto.ColdWaterMeterDto;
import com.offsidegaming.monitoring.dto.GasMeterDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class GasMeter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private Double value;

    private LocalDate dateOfMeasurement;

    public GasMeterDto toDto(){
        GasMeterDto gasMeterDto = new GasMeterDto();
        gasMeterDto.setDateOfMeasurement(this.dateOfMeasurement);
        gasMeterDto.setValue(this.value);
        return gasMeterDto;
    }

    public static GasMeter toEntity(GasMeterDto gasMeterDto, User user){
        GasMeter gasMeter = new GasMeter();
        gasMeter.user = user;
        gasMeter.value = gasMeterDto.getValue();
        gasMeter.dateOfMeasurement = gasMeterDto.getDateOfMeasurement();
        return gasMeter;
    }
}
