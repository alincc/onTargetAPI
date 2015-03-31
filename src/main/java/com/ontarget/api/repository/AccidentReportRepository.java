package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.AccidentReport;

public interface AccidentReportRepository extends JpaRepository<AccidentReport, Integer>{

	List<AccidentReport> findByProjectIdOrderByAccidentReportIdDesc(Integer projectId);
}
