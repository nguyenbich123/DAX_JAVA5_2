package com.poly.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "MAU_")
public class Mau {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Mamau")
    private Integer maMau;
    
    @Column(name="Mausac")
    @NotBlank(message = "{NotBlank.mau.mauSac}")
    private String mauSac;
    
//    @OneToMany(mappedBy = "maMau")
//    private List<ChiTietSP> chiTietSPList;
}
