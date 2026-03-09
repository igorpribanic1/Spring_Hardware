package com.example.Hardware.repository;

import com.example.Hardware.domain.Hardware;
import com.example.Hardware.domain.HardwareType;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public interface SpringDataTypeRepository extends JpaRepository<HardwareType, Integer> {
    HardwareType findByName(String name);
}
