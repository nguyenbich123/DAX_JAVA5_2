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
@Table(name = "MHR_")
public class MHR {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Idmhr")
	private Integer idMHR;
	
	@Column(name = "Mhrong")
	private String mhRong;

}
