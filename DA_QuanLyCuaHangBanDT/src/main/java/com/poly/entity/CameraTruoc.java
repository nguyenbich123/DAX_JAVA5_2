package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CAMERATRUOC")
public class CameraTruoc {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCamTruoc;
    private String DPG;
    private String tinhNang;
}
