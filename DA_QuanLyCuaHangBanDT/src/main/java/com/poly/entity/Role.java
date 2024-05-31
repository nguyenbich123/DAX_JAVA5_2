package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "ROLE_")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_role;
    String role;

    @OneToMany(mappedBy = "role")
    List<Account> accounts;
}
