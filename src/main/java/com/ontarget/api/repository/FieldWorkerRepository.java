package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.FieldWorker;

public interface FieldWorkerRepository extends JpaRepository<FieldWorker, Integer> {

	FieldWorker findById(Integer id);

	@Query("select f from FieldWorker f order by f.id desc")
	List<FieldWorker> findAllFieldWorker();

}
