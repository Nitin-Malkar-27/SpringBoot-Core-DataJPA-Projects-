package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

	// ON Entity Queries(selects all cols of the db table)

	// SELECT * FROM JPA_DOCTOR_INFO WHERE DOCNAME=?
	public Iterable<Doctor> findByDocNameEquals(String docName);

	// SELECT * FROM JPA_DOCOTR_INFO WHERE DOCNAME=?
	public Iterable<Doctor> findByDocNameIs(String docName);

	// SELECT * FROM JPA_DOCTOR_INFO WHERE DOCNAME=?
	public Iterable<Doctor> findByDocName(String docName);

	// SELECT * FROM JPA_DOCTOR_INFO WHERE INCOME BETWEEN ? AND ?
	public Iterable<Doctor> findByIncomeBetween(double start, double end);

	// SELECT * FROM JPA_DOCTOR_INFOO WHERE SPEICALIZATION IN(?,?,?...)
	public Iterable<Doctor> findBySpecializationIn(List<String> specialaties);

	// SELECT * FROM JPA__DOCTOR_INFO WHERE DOCNAME LIKE ?
	public Iterable<Doctor> findByDocNameLike(String cond);

	// SELECT * FROM JPA_DOCTOR_INFO WHERE DOCNAME LIKE ?%
	public Iterable<Doctor> findByDocNameStartsWith(String startLetters);

	// SELECT * FROM JPA_DOCTOR_INFO WHERE DOCNAME LIKE %?
	public Iterable<Doctor> findByDocNameEndsWith(String endLetters);

	// SELECT * FROM JPA_DOCTOR_INFO WHERE DOCNAME LIKE %?%
	public Iterable<Doctor> findByDocNameContains(String letters);

	// ---------------------------------------------------------------------------------------------
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqual(double startRange, double endRange);

	public Iterable<Doctor> findBySpecializationInOrIncomeBetween(List<String> specials, double start, double end);
}
