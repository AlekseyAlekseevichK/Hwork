package com.offsidegaming.monitoring.service;

import com.offsidegaming.monitoring.model.HotWaterMeter;
import com.offsidegaming.monitoring.model.User;

import java.time.LocalDate;
import java.util.List;

public interface HotWaterMeterService {

    HotWaterMeter saveValue(HotWaterMeter hotWaterMeter);

    List<HotWaterMeter> findAllByUserAndDate(User user, LocalDate date);

    List<HotWaterMeter> findAllByUser(User user);

    void deleteByUserAndDate(User user, LocalDate date);
}
