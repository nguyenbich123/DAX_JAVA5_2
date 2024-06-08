package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    
    @Column(name="Tencamsau")
    private String tenCamSau;
    
    @ManyToOne
    @JoinColumn(name = "Iddpgcs")
    private DPGCS DPGCS;
    
    @ManyToOne
    @JoinColumn(name = "Idtncs")
    private TNCS TNCS;

    @Column(name="Denflash")
    private Boolean denFlash;
    
}
