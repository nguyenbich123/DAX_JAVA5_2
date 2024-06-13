package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "MANHINH_")
public class ManHinh {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idmanhinh")
    private Integer idManHinh;
    
    @Column(name="Tenmanhinh")
    @NotBlank(message = "{NotBlank.mhc.tenManhHinh}")
    private String tenManhHinh;
    
    @ManyToOne
    @JoinColumn(name = "Idcnmh")
    @NotNull(message = "{NotNull.mhc.CNMH}")
    private CNMH CNMH;
    
    @ManyToOne
    @JoinColumn(name = "Idmhr")
    @NotNull(message = "{NotNull.mhc.MHR}")
    private MHR MHR;
    
    @ManyToOne
    @JoinColumn(name = "Iddpgmh")
    @NotNull(message = "{NotNull.mhc.DPG}")
    private DPGMH DPG;
}
