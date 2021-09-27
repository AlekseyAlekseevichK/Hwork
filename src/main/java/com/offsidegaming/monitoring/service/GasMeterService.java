package com.offsidegaming.monitoring.service;

import com.offsidegaming.monitoring.model.GasMeter;
import com.offsidegaming.monitoring.model.User;

import java.time.LocalDate;
import java.util.List;

public interface GasMeterService {

    GasMeter saveValue(GasMeter gasMeter);

    List<GasMeter> findAllByUserAndDate(User user, LocalDate date);

    List<GasMeter> findAllByUser(User user);

    void deleteByUserAndDate(User user, LocalDate date);
}
