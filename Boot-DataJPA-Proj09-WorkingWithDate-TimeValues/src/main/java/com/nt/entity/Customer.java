package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "CUSTOMER_INFO")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -809945932080669291L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer custId;

	@NonNull
	@Column(length = 20)
	private String custName;

	@NonNull
	@Column(length = 20)
	private String custAddrs;

	@NonNull
	private LocalDateTime dob;

	@NonNull
	private LocalTime top;

	@NonNull
	private LocalDate dop;

}
