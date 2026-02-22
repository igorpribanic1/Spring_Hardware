package com.example.Hardware.dto;

import com.example.Hardware.domain.HardwareType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HardwareDTO {
    private String name;
    private String code;
    private BigDecimal price;
    private HardwareType hardwareType;
    private Integer quantity;
}
