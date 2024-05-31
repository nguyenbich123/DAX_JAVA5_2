package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CAMERASAU")
public class CameraSau {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCamSau;
    private String DPG;
    private Boolean denFlash;
    private String tinhNang;
}
