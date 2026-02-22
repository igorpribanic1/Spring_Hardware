package com.example.Hardware.service;

import com.example.Hardware.dto.HardwareDTO;

import java.util.List;

public interface HardwareService {
    List<HardwareDTO> getAllHardware();
    List<HardwareDTO> getHardwareByCode(String code);
}