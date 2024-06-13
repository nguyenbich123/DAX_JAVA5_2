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
@Table(name = "PINSAC_")
public class PinSac {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idpin")
    private Integer idPin;
    
    @Column(name="Tenpin")
    @NotBlank(message = "{NotBlank.pinsac.tenPin}")
    private String tenPin;
    
    @ManyToOne
    @JoinColumn(name = "Iddlp")
    @NotNull(message = "{NotNull.pinsac.DLPin}")
    private DLP DLPin;
    
    @ManyToOne
    @JoinColumn(name = "Idlp")
    @NotNull(message = "{NotNull.pinsac.loaiPin}")
    private LP loaiPin;
    
    @ManyToOne
    @JoinColumn(name = "Idhts")
    @NotNull(message = "{NotNull.pinsac.hoTroSac}")
    private HTS hoTroSac;
    
    @ManyToOne
    @JoinColumn(name = "Idcnp")
    @NotNull(message = "{NotNull.pinsac.CNP}")
    private CNP CNP;
}
