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
@Table(name = "MANHINH_")
public class ManHinh {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idmanhinh")
    private Integer idManHinh;
    private String CNMH;
    
    @Column(name="Mhrong")
    private String MHRong;
    private String DPG;
}
