package com.offsidegaming.monitoring.service.impl;

import com.offsidegaming.monitoring.model.HotWaterMeter;
import com.offsidegaming.monitoring.model.User;
import com.offsidegaming.monitoring.repository.HotWaterMeterRepository;
import com.offsidegaming.monitoring.service.HotWaterMeterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotWaterMeterServiceImpl implements HotWaterMeterService {

    private final HotWaterMeterRepository hotWaterMeterRepository;

    public HotWaterMeterServiceImpl(HotWaterMeterRepository hotWaterMeterRepository) {
        this.hotWaterMeterRepository = hotWaterMeterRepository;
    }

    @Override
    @Transactional
    public HotWaterMeter saveValue(HotWaterMeter hotWaterMeter) {
        return hotWaterMeterRepository.save(hotWaterMeter);
    }

    @Override
    @Transactional
    public List<HotWaterMeter> findAllByUserAndDate(User user, LocalDate date) {
        return hotWaterMeterRepository.findAllByUserAndAndDateOfMeasurement(user, date);
    }

    @Override
    @Transactional
    public List<HotWaterMeter> findAllByUser(User user) {
        return hotWaterMeterRepository.findAllByUser(user);
    }

    @Override
    @Transactional
    public void deleteByUserAndDate(User user, LocalDate date) {
        hotWaterMeterRepository.deleteByUserAndAndDateOfMeasurement(user, date);
    }
}
