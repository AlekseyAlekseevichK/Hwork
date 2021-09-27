package com.offsidegaming.monitoring.repository;

import com.offsidegaming.monitoring.model.GasMeter;
import com.offsidegaming.monitoring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface GasMeterRepository extends JpaRepository<GasMeter, Long> {

    List<GasMeter> findAllByUser(User user);

    List<GasMeter> findAllByUserAndAndDateOfMeasurement(User user, LocalDate date);

    void deleteByUserAndAndDateOfMeasurement(User user, LocalDate date);
}
