package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "JPA_DOCTOR_INFO")
@Data
public class Doctor {

	@Id
	@Column(name = "DOC_ID")
	@SequenceGenerator(name = "gen1", sequenceName = "DOCID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer docId;

	@Column(name = "DOC_NAME", length = 20)
	private String docName;

	@Column(name = "SPECIALIZATION", length = 25)
	private String specialization;

	@Column(name = "INCOME")
	private Double income;

}
