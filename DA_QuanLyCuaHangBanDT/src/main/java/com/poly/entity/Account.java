package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    String tenDN;
    String matKhau;
    String hoTen;
    String sdt;
    String email;
    String img;

    @ManyToOne
    @JoinColumn(name = "ID_ROLE")
    Role role;

    @ManyToOne
    @JoinColumn(name = "ID_TTHD")
    TrangThaiHD tthd;
    
//    @OneToMany
//    @JoinColumn(name="ID_DIACHI")
//    DiaChi diaChi;

}
