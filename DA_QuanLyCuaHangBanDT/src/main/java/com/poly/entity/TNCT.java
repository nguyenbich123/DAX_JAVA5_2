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
@Table(name = "TNCT_")
public class TNCT {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Idtnct")
	private Integer idTNCT;
	
	@Column(name = "Tinhnang")
	private String tinhNang;

}
