package com.example.Hardware.repository;

import com.example.Hardware.domain.Hardware;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public interface SpringDataHardwareRepository extends JpaRepository<Hardware, Integer> {
    List<Hardware> findByName(String name);
    List<Hardware> findByCode(String code);
    List<Hardware> findByHardwareTypeId(Integer hardwareTypeId);
}
