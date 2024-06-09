package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "CNMH_")
public class CNMH {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Idcnmh")
	private Integer idCNMH;
	
	@NotBlank(message = "{NotBlank.item.cnmh}")
	@Column(name = "Cnmh")
	private String cnmh;

}
