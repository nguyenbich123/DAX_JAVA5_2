package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "TTDH_")
public class TTDH{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idttdh")
    private Integer id_TTDH;
    
    @Column(name="Trangthai")
    @NotBlank(message = "{NotBlank.ttHD2.trangThai}")
    private String trangThai;
}
