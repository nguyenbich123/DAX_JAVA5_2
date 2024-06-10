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
@Table(name = "TRANGTHAITT_")
public class TrangThaiTT {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idtttt")
    Integer id_TTTT;
    
    @Column(name="Trangthai")
    @NotBlank(message = "{NotBlank.ttThanht.trangThai}")
    String trangThai;
}
