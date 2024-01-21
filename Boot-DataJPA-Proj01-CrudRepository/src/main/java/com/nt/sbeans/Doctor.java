package com.nt.sbeans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Transient;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "JPA_DOCTOR_INFO")
public class Doctor {

	@Id
	@Column(name = "DOC_ID")
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "gen1", sequenceName = "DOCID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer docId;

	@Column(name = "DOC_NAME", length = 25)
	private String docName;

	@Column(name = "SPECIALIZATION", length = 20)
	private String specialization;
	
	//@Transient
	@Column(name = "INCOME")
	private Double income;

}
