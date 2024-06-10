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
    @NotBlank(message = "{NotBlank.mh.tenManHinh}")
    private String tenManhHinh;

    @ManyToOne
    @JoinColumn(name = "Idcnmh")
    @NotBlank(message = "{NotBlank.mh.CNMH}")
    private CNMH CNMH;
    
    @ManyToOne
    @JoinColumn(name = "Idmhr")
     @NotBlank(message = "{NotBlank.mh.MHR}")
    private MHR MHR;
    
    @ManyToOne
    @JoinColumn(name = "Iddpgmh")
    @NotBlank(message = "{NotBlank.mh.DPGMH}")
    private DPGMH DPGMH;
}
