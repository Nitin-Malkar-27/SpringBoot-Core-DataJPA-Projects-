package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.sbeans.Doctor;

public interface IDoctorRepo extends CrudRepository<Doctor,Integer> {

}
