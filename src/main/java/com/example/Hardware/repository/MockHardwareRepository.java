package com.example.Hardware.repository;

import com.example.Hardware.domain.Hardware;
import com.example.Hardware.domain.HardwareType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MockHardwareRepository implements HardwareRepository{

    private static List<Hardware> hardwareList;

    static{
        hardwareList = new ArrayList<>();

        Hardware hardware1 = new Hardware(1, "CPU1", "c_001", new BigDecimal(100), HardwareType.CPU, 10);
        Hardware hardware2 = new Hardware(1, "CPU2", "c_002", new BigDecimal(125), HardwareType.CPU, 8);

        hardwareList.add(hardware1);
        hardwareList.add(hardware2);
    }

    public List<Hardware> getAllHardware() {
        return hardwareList;
    }

    public List<Hardware> getHardwareByCode(String code){
        return hardwareList.stream()
                .filter(h -> h.getCode().toLowerCase().equals(code.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Integer saveNewHardware(Hardware hardware){
        Integer generatedId = hardwareList.size() + 1;
        hardware.setId(generatedId);
        hardwareList.add(hardware);
        return generatedId;
    }

    public Optional<Hardware> updateHardware(Hardware hardwareToUpdate, Integer id){
        Optional<Hardware> storedHardwareOptional = hardwareList.stream().filter(h -> h.getId().equals(id)).findFirst();
        if(storedHardwareOptional.isPresent()) {
            Hardware storedHardware = storedHardwareOptional.get();
            storedHardware.setName(hardwareToUpdate.getName());
            storedHardware.setCode(hardwareToUpdate.getCode());
            storedHardware.setPrice(hardwareToUpdate.getPrice());
            storedHardware.setHardwareType(hardwareToUpdate.getHardwareType());
            storedHardware.setQuantity(hardwareToUpdate.getQuantity());

            return Optional.of(storedHardware);
        }

        return Optional.empty();
    }


    public boolean hardwareByIdExists(Integer id) {
        return hardwareList.stream().anyMatch(h -> h.getId().equals(id));
    }


    public boolean deleteHardwareById(Integer id) {
        return hardwareList.removeIf(h -> h.getId().equals(id));
    }


}
