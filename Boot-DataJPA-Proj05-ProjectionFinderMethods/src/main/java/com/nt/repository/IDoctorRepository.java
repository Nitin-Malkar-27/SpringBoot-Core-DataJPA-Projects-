package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;
import com.nt.view.IResultView;
import com.nt.view.IView;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

	// fiinder method for the static projection operations
	public Iterable<IResultView> findBySpecializationIn(List<String> specials);

	// finder method for the dynamic projection operations
	public <T extends IView> Iterable<T> findByIncomeBetween(double start, double end, Class<T> clazz);
}
