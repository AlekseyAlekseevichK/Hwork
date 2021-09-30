package com.offsidegaming.monitoring.service.impl;

import com.offsidegaming.monitoring.model.ColdWaterMeter;
import com.offsidegaming.monitoring.model.User;
import com.offsidegaming.monitoring.repository.ColdWaterMeterRepository;
import com.offsidegaming.monitoring.service.ColdWaterMeterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ColdWaterMeterServiceImpl implements ColdWaterMeterService {

    private final ColdWaterMeterRepository coldWaterMeterRepository;

    public ColdWaterMeterServiceImpl(ColdWaterMeterRepository coldWaterMeterRepository) {
        this.coldWaterMeterRepository = coldWaterMeterRepository;
    }

    @Override
    @Transactional
    public ColdWaterMeter saveValue(ColdWaterMeter coldWaterMeter) {
        return coldWaterMeterRepository.save(coldWaterMeter);
    }

    @Override
    @Transactional
    public List<ColdWaterMeter> findAllByUserAndDate(User user, LocalDate date) {
        return coldWaterMeterRepository.findAllByUserAndAndDateOfMeasurement(user, date);
    }

    @Override
    @Transactional
    public List<ColdWaterMeter> findAllByUser(User user) {
        return coldWaterMeterRepository.findAllByUser(user);
    }

    @Override
    @Transactional
    public void deleteByUserAndDate(User user, LocalDate date) {
        coldWaterMeterRepository.deleteByUserAndAndDateOfMeasurement(user, date);
    }
}
