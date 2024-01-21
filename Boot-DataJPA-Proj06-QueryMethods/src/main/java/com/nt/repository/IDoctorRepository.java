package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Doctor;

import jakarta.transaction.Transactional;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	/*// @Query("FROM Doctor where income>=?1 AND income<=?2")
	// @Query("FRoM com.nt.entity.Doctor WHERE income>=?1 AND income<=?2")
	// @Query(" from Doctor doc WHERE doc.income>=?1 AND doc.income<=?2")
	// @Query(" from Doctor doc WHERE doc.income>=? AND doc.income<=?") //show
	// Exception
	// @Query("SELECT doc FROM Doctor doc where doc.income>=?1 and doc.income<=?2")
	
	public List<Doctor> searchDoctorsByIncomeRange(double startRange, double endRange);*/

	/*@Query(" FROM Doctor where income>=:start AND income<=:end")
	public List<Doctor> searchDoctorsByIncomeRange(@Param("start") double startRange, @Param("end") double endRange);*/

	@Query("FROM Doctor WHERE income>=:start AND income<=:end")
	public List<Doctor> searchDoctorsByIncomeRange(double start, double end);

	// -------------------------Select --Entity Query-------------------

	@Query(" FROM Doctor WHERE specialization IN(:sp1,:sp2)ORDER BY specialization")
	public List<Doctor> searchDoctorBySpecialization(String sp1, String sp2);

	// ----Select --Projection Query with specific multiple col values-----

	@Query("SELECT docId, docName,income FROM Doctor where income between :start AND :end ")
	public List<Object[]> searchDoctorDataByIncome(double start, double end);

	// ---Select --Projection Query with specific single col values---
	@Query("Select docName FROM Doctor where income between :min and :max")
	public List<String> searchAllDoctorNamesByIncomeRange(double min, double max);

	// --------Entity Query giving single record-----------
	@Query(" FROM Doctor where docName=:name")
	public Optional<Doctor> showDoctorInfoByName(String name);

	// -------Scalar Query giving single reocrd multiple col values--------------
	@Query("SELECT docId,docName FROM Doctor where docName=:name")
	public Object showDoctorDataByName(String name);

	// ------Scalar Query giving single record single col values-----
	@Query("SELECT specialization FROM Doctor where docName=:name")
	public String showSpecializationByName(String name);

	// HQL/JPQL supts aggregate operations like count(*),max(-),min(-),avg(-) & etc

	@Query("SELECT count(distinct docName) From Doctor")
	public int fetchDoctorsNameCount();

	@Query("SELECT count(*),max(income),min(income),avg(income),sum(income) from Doctor")
	public Object fetchAggregateData();

	// -------------------- Non-select Operations using HQL/JPQL -------

	@Query("UPDATE Doctor SET income=income+(income*:percentage/100.0) WHERE specialization=:sp")
	@Modifying
	@Transactional
	public int hikeDoctorsIncomeBySpecialization(String sp, double percentage);

	@Query("DELETE FROM Doctor WHERE income>=:start AND income<=:end")
	@Modifying
	@Transactional
	public int removeDoctorsByIncomeRange(double start, double end);

	// -----------------------Native SQL Query----------------

	@Query(value = "INSERT INTO JPA_DOCTOR_INFO VALUES(DOCID_SEQ.NEXTVAL,:name,:income,:special)", nativeQuery = true)
	@Modifying
	@Transactional
	public int registerDoctor(String name, String special, double income);

	@Query(value = "Select SYSDATE FROM DUAL", nativeQuery = true)
	public String showSystemDate();

	@Query(value = "Create table TEMP(col1 number(5))", nativeQuery = true)
	@Modifying
	@Transactional
	public int createTempTable();

}
