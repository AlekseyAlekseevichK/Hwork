package com.offsidegaming.monitoring.facade;

import com.offsidegaming.monitoring.dto.*;
import com.offsidegaming.monitoring.model.ColdWaterMeter;
import com.offsidegaming.monitoring.model.GasMeter;
import com.offsidegaming.monitoring.model.HotWaterMeter;
import com.offsidegaming.monitoring.model.User;
import com.offsidegaming.monitoring.repository.ColdWaterMeterRepository;
import com.offsidegaming.monitoring.repository.GasMeterRepository;
import com.offsidegaming.monitoring.repository.HotWaterMeterRepository;
import com.offsidegaming.monitoring.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MetersFacade {
    private final ColdWaterMeterRepository coldWaterMeterRepository;
    private final GasMeterRepository gasMeterRepository;
    private final HotWaterMeterRepository hotWaterMeterRepository;
    private final UserRepository userRepository;

    public MetersFacade(ColdWaterMeterRepository coldWaterMeterRepository, GasMeterRepository gasMeterRepository,
                        HotWaterMeterRepository hotWaterMeterRepository, UserRepository userRepository) {
        this.coldWaterMeterRepository = coldWaterMeterRepository;
        this.gasMeterRepository = gasMeterRepository;
        this.hotWaterMeterRepository = hotWaterMeterRepository;
        this.userRepository = userRepository;
    }


    public ShowMetersDto getMetersByUserAndDate(Long id, LocalDate date) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            ShowMetersDto metersDto = new ShowMetersDto();
            User user = userOptional.get();
            metersDto.setUserId(id);
            metersDto.setGasMeters(user.getGasMeters().stream().map(GasMeter::toDto).collect(Collectors.toList()));
            metersDto.setColdWaterMeters(user.getColdWaterMeters().stream().map(ColdWaterMeter::toDto).collect(Collectors.toList()));
            metersDto.setHotWaterMeters(user.getHotWaterMeters().stream().map(HotWaterMeter::toDto).collect(Collectors.toList()));
            return metersDto;
        } else {
            return null;
        }
    }

    public String saveMetersDto(SaveMetersDto saveMetersDto) {
        Optional<User> userOptional = userRepository.findById(saveMetersDto.getUserId());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String status = "";
            GasMeterDto gasMeterDto = saveMetersDto.getGasMeter();
            HotWaterMeterDto hotWaterMeterDto = saveMetersDto.getHotWaterMeter();
            ColdWaterMeterDto coldWaterMeterDto = saveMetersDto.getColdWaterMeter();

            if (gasMeterDto != null && (gasMeterDto.getValue() != null && gasMeterDto.getDateOfMeasurement() != null)) {
                gasMeterRepository.save(GasMeter.toEntity(gasMeterDto, user));
            } else {
                status += "\ngasMeter -> null or not all fields are filled";
            }

            if (hotWaterMeterDto != null && (hotWaterMeterDto.getValue() != null && hotWaterMeterDto.getDateOfMeasurement() != null)) {
                hotWaterMeterRepository.save(HotWaterMeter.toEntity(hotWaterMeterDto, user));
            } else {
                status += "\nhotWaterMeter -> null or not all fields are filled";
            }

            if (coldWaterMeterDto != null && (coldWaterMeterDto.getValue() != null && coldWaterMeterDto.getDateOfMeasurement() != null)) {
                coldWaterMeterRepository.save(ColdWaterMeter.toEntity(coldWaterMeterDto, user));
            } else {
                status += "\ncoldWaterMeterDto -> null or not all fields are filled";
            }return "Success -> {" + status + "\n}";
        } else {
            return "User not found";
        }
    }
}
