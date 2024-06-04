package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ACCOUNT_")
public class Account {

    @Id
    @Column(name="Tendn")
    String tenDN;
    
    @Column(name="Matkhau")
    String matKhau;
    
    @Column(name="Hoten")
    String hoTen;
    
    String sdt;
    String email;
    String img;

    @ManyToOne
    @JoinColumn(name = "Idrole")
    Role role;

    @ManyToOne
    @JoinColumn(name = "Idtthd")
    TrangThaiHD tthd;
    
//    @OneToMany
//    @JoinColumn(name="ID_DIACHI")
//    DiaChi diaChi;

}
