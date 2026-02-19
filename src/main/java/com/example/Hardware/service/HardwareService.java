package com.example.Hardware.service;

import com.example.Hardware.domain.Hardware;

import java.util.List;

public interface HardwareService {
    List<Hardware> getAllHardware();
    List<Hardware> getHardwareByCode(String code);
}