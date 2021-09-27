package com.offsidegaming.monitoring.repository;

import com.offsidegaming.monitoring.model.ColdWaterMeter;
import com.offsidegaming.monitoring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ColdWaterMeterRepository extends JpaRepository<ColdWaterMeter, Long> {

    List<ColdWaterMeter> findAllByUser(User user);

    List<ColdWaterMeter> findAllByUserAndAndDateOfMeasurement(User user, LocalDate date);

    void deleteByUserAndAndDateOfMeasurement(User user, LocalDate date);
}
