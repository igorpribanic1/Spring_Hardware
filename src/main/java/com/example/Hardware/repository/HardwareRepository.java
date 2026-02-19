package com.example.Hardware.repository;

import com.example.Hardware.domain.Hardware;

import java.util.List;

public interface HardwareRepository {
    List<Hardware> getAllHardware();
    List<Hardware> getHardwareByCode(String code);
}
