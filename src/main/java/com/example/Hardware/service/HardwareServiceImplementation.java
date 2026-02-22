package com.example.Hardware.service;

import com.example.Hardware.domain.Hardware;
import com.example.Hardware.dto.HardwareDTO;
import com.example.Hardware.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HardwareServiceImplementation implements HardwareService{

    private HardwareRepository hardwareRepository;

    public List<HardwareDTO> getAllHardware() {
        return hardwareRepository.getAllHardware().stream().map(this::convertHardwareToHardwareDTO).toList();
    }

    public List<HardwareDTO> getHardwareByCode(String code){
        return hardwareRepository.getHardwareByCode(code).stream().map(this::convertHardwareToHardwareDTO).toList();
    }

    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware){
        return new HardwareDTO(hardware.getName(), hardware.getCode(), hardware.getPrice(), hardware.getHardwareType(), hardware.getQuantity());
    }

    private Hardware convertHardwareDTOToHardware(HardwareDTO hardwareDTO){
        Integer latestId = hardwareRepository.getAllHardware().stream().max((h1, h2) -> h1.getId().compareTo(h2.getId())).get().getId();
        return new Hardware(latestId + 1, hardwareDTO.getName(), hardwareDTO.getCode(), hardwareDTO.getPrice(), hardwareDTO.getHardwareType(), hardwareDTO.getQuantity());
    }
}
