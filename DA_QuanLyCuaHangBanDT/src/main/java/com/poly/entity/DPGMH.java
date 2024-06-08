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
@Table(name = "DPGMH_")
public class DPGMH {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Iddpgmh")
	private Integer idDPGMH;
	
	@Column(name = "Dpg")
	@NotBlank(message = "{NotBlank.dpg.dpg}")
	private String dpg;

}
