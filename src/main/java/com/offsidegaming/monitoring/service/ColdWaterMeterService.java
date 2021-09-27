package com.offsidegaming.monitoring.service;

import com.offsidegaming.monitoring.model.ColdWaterMeter;
import com.offsidegaming.monitoring.model.User;

import java.time.LocalDate;
import java.util.List;

public interface ColdWaterMeterService {

    ColdWaterMeter saveValue(ColdWaterMeter coldWaterMeter);

    List<ColdWaterMeter> findAllByUserAndDate(User user, LocalDate date);

    List<ColdWaterMeter> findAllByUser(User user);

    void deleteByUserAndDate(User user, LocalDate date);
}
