package com.offsidegaming.monitoring.controller;

import com.offsidegaming.monitoring.dto.SaveMetersDto;
import com.offsidegaming.monitoring.dto.ShowMetersDto;
import com.offsidegaming.monitoring.facade.MetersFacade;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("monitoring")
public class MetersController {
    private final MetersFacade metersFacade;

    public MetersController(MetersFacade metersFacade) {
        this.metersFacade = metersFacade;
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody SaveMetersDto saveMetersDto){
        return metersFacade.saveMetersDto(saveMetersDto);

    }

    @GetMapping("/find/{id}&{date}")
    public ShowMetersDto findUser(@PathVariable Long id, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return metersFacade.getMetersByUserAndDate(id, date);
    }
}


