package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class GioHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maGH;
    
    @ManyToOne
    @JoinColumn(name = "TenDN")
    private Account maKH;
}
