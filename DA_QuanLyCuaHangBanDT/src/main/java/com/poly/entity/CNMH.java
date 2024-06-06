package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CNMH_")
public class CNMH {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Idcnmh")
	private Integer idCNMH;
	
	@Column(name = "Cnmh")
	private String cnmh;

}
