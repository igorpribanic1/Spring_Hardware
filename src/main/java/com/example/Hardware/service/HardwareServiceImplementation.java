package com.example.Hardware.service;

import com.example.Hardware.domain.Hardware;
import com.example.Hardware.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HardwareServiceImplementation implements HardwareService{

    private HardwareRepository hardwareRepository;

    public List<Hardware> getAllHardware() {
        return hardwareRepository.getAllHardware();
    }

    public List<Hardware> getHardwareByCode(String code){
        return hardwareRepository.getHardwareByCode(code);
    }
}
