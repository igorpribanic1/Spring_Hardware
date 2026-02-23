package com.example.Hardware.repository;

import com.example.Hardware.domain.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {
    List<Hardware> getAllHardware();
    List<Hardware> getHardwareByCode(String code);
    Integer saveNewHardware(Hardware hardware);
    Optional<Hardware> updateHardware(Hardware hardwareToUpdate, Integer id);
    boolean hardwareByIdExists(Integer id);
    boolean deleteHardwareById(Integer id);
}
