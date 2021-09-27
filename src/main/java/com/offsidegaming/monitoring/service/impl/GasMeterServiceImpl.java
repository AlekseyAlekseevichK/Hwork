package com.offsidegaming.monitoring.service.impl;

import com.offsidegaming.monitoring.model.GasMeter;
import com.offsidegaming.monitoring.model.User;
import com.offsidegaming.monitoring.repository.GasMeterRepository;
import com.offsidegaming.monitoring.service.GasMeterService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GasMeterServiceImpl implements GasMeterService {

    private final GasMeterRepository gasMeterRepository;

    public GasMeterServiceImpl(GasMeterRepository gasMeterRepository) {
        this.gasMeterRepository = gasMeterRepository;
    }

    @Override
    public GasMeter saveValue(GasMeter gasMeter) {
        return gasMeterRepository.save(gasMeter);
    }

    @Override
    public List<GasMeter> findAllByUserAndDate(User user, LocalDate date) {
        return gasMeterRepository.findAllByUserAndAndDateOfMeasurement(user, date);
    }

    @Override
    public List<GasMeter> findAllByUser(User user) {
        return gasMeterRepository.findAllByUser(user);
    }

    @Override
    public void deleteByUserAndDate(User user, LocalDate date) {
        gasMeterRepository.deleteByUserAndAndDateOfMeasurement(user, date);
    }
}
