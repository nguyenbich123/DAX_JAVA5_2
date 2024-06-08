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
@Table(name = "LP_")
public class LP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Idlp")
	private Integer idlp;
	
	@Column(name = "loaipin")
	private String loaiPin;

}

