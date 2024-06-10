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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "{NotBlank.item.tenCamSau}")
    private String tenCamSau;

    @ManyToOne
    @JoinColumn(name = "Iddpgcs")
    @NotNull(message = "{NotNull.item.DPGCS}")
    private DPGCS DPGCS;

    @ManyToOne
    @JoinColumn(name = "Idtncs")
    @NotNull(message = "{NotNull.item.TNCS}")
    private TNCS TNCS;

    @Column(name="Denflash")
    @NotNull(message = "{NotNull.item.denFlash}")
    private Boolean denFlash;

}
