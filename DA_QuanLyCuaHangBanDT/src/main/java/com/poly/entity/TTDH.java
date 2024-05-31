package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TTDH")
public class TTDH{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_TTDH;
    private String trangThai;
}
