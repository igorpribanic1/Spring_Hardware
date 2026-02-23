package com.example.Hardware.controller;

import com.example.Hardware.domain.Hardware;
import com.example.Hardware.dto.HardwareDTO;
import com.example.Hardware.service.HardwareService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardware")
@AllArgsConstructor
public class HardwareController {

    private HardwareService hardwareService;

    @GetMapping
    public List<HardwareDTO> getAllHardware() {
        return hardwareService.getAllHardware().stream().toList();
    }

    @GetMapping("/{hardwareCode}")
    public List<HardwareDTO> getHardwareByCode(@PathVariable String hardwareCode) {
        return hardwareService.getHardwareByCode(hardwareCode);
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveNewHardware(@Valid @RequestBody HardwareDTO hardwareDTO) {
        Integer generatedId = hardwareService.saveNewHardware(hardwareDTO);
        return ResponseEntity.ok(generatedId);
    }

    @PutMapping("/{hardwareId}")
    public ResponseEntity<HardwareDTO> updateHardware(@Valid @RequestBody HardwareDTO hardwareDTO, @PathVariable Integer hardwareId) {
        if (hardwareService.hardwareByIdExists(hardwareId)) {
            hardwareService.updateHardware(hardwareDTO, hardwareId);
            return ResponseEntity.ok(hardwareDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{hardwareId}")
    public ResponseEntity<?> deleteHardware(@PathVariable Integer hardwareId) {
        if(hardwareService.hardwareByIdExists(hardwareId)) {
            boolean result = hardwareService.deleteHardwareById(hardwareId);
            if(result) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
