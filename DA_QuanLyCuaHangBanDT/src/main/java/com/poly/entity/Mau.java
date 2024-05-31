package com.poly.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "MAU_")
public class Mau {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maMau;
    private String mauSac;
    
//    @OneToMany(mappedBy = "maMau")
//    private List<ChiTietSP> chiTietSPList;
}
