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
@Table(name = "MANHINH_")
public class ManHinh {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idmanhinh")
    private Integer idManHinh;
    
    @ManyToOne
    @JoinColumn(name = "Idcnmh")
    private CNMH CNMH;
    
    @ManyToOne
    @JoinColumn(name = "Idmhr")
    private MHR MHR;
    
    @ManyToOne
    @JoinColumn(name = "Iddpgmh")
    private DPGMH DPG;
}
