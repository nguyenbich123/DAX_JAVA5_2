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
    @NotBlank(message = "{NotBlank.pinsac.DLPin}")
    private DLP DLPin;

    @ManyToOne
    @JoinColumn(name = "Idlp")
    @NotBlank(message = "{NotBlank.pinsac.loaiPin}")
    private LP loaiPin;

    @ManyToOne
    @JoinColumn(name = "Idhts")
    @NotBlank(message = "{NotBlank.pinsac.hoTroSac}")
    private HTS hoTroSac;

    @ManyToOne
    @JoinColumn(name = "Idcnp")
    @NotBlank(message = "{NotBlank.pinsac.CNP}")
    private CNP CNP;
}
