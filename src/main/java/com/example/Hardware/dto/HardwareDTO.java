package com.example.Hardware.dto;

import com.example.Hardware.domain.HardwareType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HardwareDTO {
    @NotNull(message = "Hardware name cannot be blank!")
    private String name;

    @NotNull(message = "Hardware code cannot be blank!")
    private String code;

    @DecimalMin(value = "0.0", message = "Hardware price must be positive!")
    private BigDecimal price;

    @NotNull(message = "Hardware type cannot be blank!")
    private HardwareType hardwareType;

    @PositiveOrZero(message = "Hardware quantity must be positive or zero!")
    private Integer quantity;
}
