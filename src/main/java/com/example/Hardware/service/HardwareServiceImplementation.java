package com.example.Hardware.service;

import com.example.Hardware.domain.Hardware;
import com.example.Hardware.domain.HardwareType;
import com.example.Hardware.dto.HardwareDTO;
import com.example.Hardware.repository.HardwareRepository;
import com.example.Hardware.repository.SpringDataHardwareRepository;
import com.example.Hardware.repository.SpringDataTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HardwareServiceImplementation implements HardwareService{

    /*private HardwareRepository hardwareRepository;*/

    private SpringDataHardwareRepository hardwareRepository;
    private SpringDataTypeRepository hardwareTypeRepository;

    public List<HardwareDTO> getAllHardware() {
        return hardwareRepository.findAll().stream().map(this::convertHardwareToHardwareDTO).toList();

        /*return hardwareRepository.getAllHardware().stream().map(this::convertHardwareToHardwareDTO).toList();*/
    }

    public List<HardwareDTO> getHardwareByCode(String code){
        return hardwareRepository.findByCode(code).stream().map(this::convertHardwareToHardwareDTO).toList();

        /*return hardwareRepository.getHardwareByCode(code).stream().map(this::convertHardwareToHardwareDTO).toList();*/
    }

    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware){
        return new HardwareDTO(hardware.getName(), hardware.getCode(), hardware.getPrice(), hardware.getHardwareType().getName(), hardware.getQuantity());
    }

    private Hardware convertHardwareDTOToHardware(HardwareDTO hardwareDTO){
        Hardware hardware = new Hardware();
        hardware.setName(hardwareDTO.getName());
        hardware.setCode(hardwareDTO.getCode());
        hardware.setPrice(hardwareDTO.getPrice());
        HardwareType hardwareType = hardwareTypeRepository.findByName(hardwareDTO.getHardwareTypeName());
        if (hardwareType == null) {
            throw new IllegalArgumentException("Hardware type with name '" + hardwareDTO.getHardwareTypeName() + "' not found.");

        }
        hardware.setHardwareType(hardwareType);
        hardware.setQuantity(hardwareDTO.getQuantity());
        return hardware;


       /* Integer latestId = hardwareRepository.getAllHardware().stream().max((h1, h2) -> h1.getId().compareTo(h2.getId())).get().getId();
        return new Hardware(latestId + 1, hardwareDTO.getName(), hardwareDTO.getCode(), hardwareDTO.getPrice(), hardwareDTO.getHardwareType(), hardwareDTO.getQuantity());*/
    }


    public HardwareDTO saveNewHardware(HardwareDTO hardwareDTO) {
        return convertHardwareToHardwareDTO(hardwareRepository.save(convertHardwareDTOToHardware(hardwareDTO)));
       /* return hardwareRepository.saveNewHardware(convertHardwareDTOToHardware(hardwareDTO));*/
    }


    public Optional<HardwareDTO> updateHardware(HardwareDTO hardwareDTO, Integer id) {
        Optional<Hardware> hardwareToUpdate = hardwareRepository.findById(id);

        if(hardwareToUpdate.isPresent()) {
            Hardware hardware = hardwareToUpdate.get();
            hardware.setName(hardwareDTO.getName());
            hardware.setCode(hardwareDTO.getCode());
            hardware.setPrice(hardwareDTO.getPrice());
            HardwareType hardwareType = hardwareTypeRepository.findByName(hardwareDTO.getHardwareTypeName());
            if (hardwareType == null) {
                throw new IllegalArgumentException("Hardware type with name '" + hardwareDTO.getHardwareTypeName() + "' not found.");

            }
            hardware.setHardwareType(hardwareType);
            hardware.setQuantity(hardwareDTO.getQuantity());

            Hardware updatedHardware = hardwareRepository.save(hardware);

            return Optional.of(convertHardwareToHardwareDTO(updatedHardware));
        }

        return Optional.empty();
    }


    public boolean hardwareByIdExists(Integer id) {
        return hardwareRepository.findById(id).isPresent();
        /*return hardwareRepository.hardwareByIdExists(id);*/
    }


    public boolean deleteHardwareById(Integer id) {
        if (hardwareByIdExists(id)) {
            hardwareRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
       /* return hardwareRepository.deleteHardwareById(id);*/
    }
}
