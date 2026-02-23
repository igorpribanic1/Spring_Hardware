package com.example.Hardware.service;

import com.example.Hardware.domain.Hardware;
import com.example.Hardware.dto.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareService {
    List<HardwareDTO> getAllHardware();
    List<HardwareDTO> getHardwareByCode(String code);
    Integer saveNewHardware(HardwareDTO hardwareDTO);
    Optional<HardwareDTO> updateHardware(HardwareDTO hardwareDTOToUpdate, Integer id);
    boolean hardwareByIdExists(Integer id);
    boolean deleteHardwareById(Integer id);
}