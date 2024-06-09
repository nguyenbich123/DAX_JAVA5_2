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
@Table(name = "CAMERATRUOC_")
public class CameraTruoc {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idcamtruoc")
    @NotBlank(message = "{NotBlank.ct.tenCamTruoc}")
    private Integer idCamTruoc;
    
    @Column(name="Tencamtruoc")
     @NotBlank(message = "{NotBlank.ct.DPGCT}")
    private String tenCamTruoc;
    
    @ManyToOne
    @JoinColumn(name = "Iddpgct")
    private DPGCT DPGCT;
    
    @ManyToOne
    @JoinColumn(name = "Idtnct")
     @NotBlank(message = "{NotBlank.ct.TNCT}")
    private TNCT TNCT;
}
