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
@Table(name = "CAMERASAU_")
public class CameraSau {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idcamsau")
    private Integer idCamSau;
    private String DPG;
    @Column(name="Denflash")
    private Boolean denFlash;
    @Column(name="Tinhnang")
    private String tinhNang;
}
