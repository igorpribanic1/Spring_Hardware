package com.example.Hardware.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Hardware")
public class Hardware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="code")
    private String code;
    @Column(name="price")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name="hardware_type_id")
    private HardwareType hardwareType;
    @Column(name="quantity")
    private Integer quantity;
}
