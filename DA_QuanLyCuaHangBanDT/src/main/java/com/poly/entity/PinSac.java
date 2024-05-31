package com.poly.entity;

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
    private Integer idPin;
    private String DLPin;
    private String loaiPin;
    private String hoTroSac;
    private String CNP;
}
