package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PINSAC_")
public class PinSac {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idpin")
    private Integer idPin;
    
    @Column(name="Dlpin")
    private String DLPin;
    
    @Column(name="Loaipin")
    private String loaiPin;
    
    @Column(name="Hotrosac")
    private String hoTroSac;
    private String CNP;
}
