package com.offsidegaming.monitoring.repository;

import com.offsidegaming.monitoring.model.HotWaterMeter;
import com.offsidegaming.monitoring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HotWaterMeterRepository extends JpaRepository<HotWaterMeter, Long> {

    List<HotWaterMeter> findAllByUser(User user);

    List<HotWaterMeter> findAllByUserAndAndDateOfMeasurement(User user, LocalDate date);

    void deleteByUserAndAndDateOfMeasurement(User user, LocalDate date);
}
