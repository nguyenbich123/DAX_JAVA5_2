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
@Table(name = "PINSAC_")
public class PinSac {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idpin")
    private Integer idPin;
    
    @Column(name="Tenpin")
    private String tenPin;
    
    @ManyToOne
    @JoinColumn(name = "Iddlp")
    private DLP DLPin;
    
    @ManyToOne
    @JoinColumn(name = "Idlp")
    private LP loaiPin;
    
    @ManyToOne
    @JoinColumn(name = "Idhts")
    private HTS hoTroSac;
    
    @ManyToOne
    @JoinColumn(name = "Idcnp")
    private CNP CNP;
}
