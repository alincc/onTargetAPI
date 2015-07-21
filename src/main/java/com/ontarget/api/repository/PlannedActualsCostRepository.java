package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.PlannedActualsCost;

public interface PlannedActualsCostRepository extends JpaRepository<PlannedActualsCost, Integer> {

	PlannedActualsCost findById(Integer id);

	@Query("select min(pac.fromDate) as min_date, max(pac.toDate) as max_date from "
			+ " PlannedActualsCost pac JOIN pac.projectTask pt join pt.project p" + " where pac.costType = ?1 and p.projectId = ?2")
	Object[] getTaskCostMinMaxDate(String costType, Integer projectId);

	@Query("select pac from PlannedActualsCost pac join pac.projectTask pt join pt.project p"
			+ " where pac.costType = ?1 and p.projectId in(" + "  select pd.projectId from pt.project pd where p.projectParentId = ?2)"
			+ " order by pt.projectTaskId asc")
	List<PlannedActualsCost> getPlannedAcutalsCostByProject(String costType, Integer projectParentId);
}
