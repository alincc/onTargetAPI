package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.PlannedActualsCost;

public interface PlannedActualsCostRepository extends JpaRepository<PlannedActualsCost, Integer> {

	@Query("select min(pac.fromDate) as min_date, max(pac.toDate) as max_date from "
			+ " PlannedActualsCost pac JOIN pac.projectTask pt join pt.project p"
			+ " where pac.costType = ?1 and p.projectId = ?2")
	Object[] getTaskCostMinMaxDate(String costType, Integer projectId);

	/*
	 * select pt.title,pt.project_task_id,pt.project_id,pac.* from
	 * planned_actuals_cost pac, project_task pt, project p ") .append(" where
	 * pac.task_id=pt.project_task_id and pt.project_id=p.project_id and
	 * pac.cost_type=? and p.project_id in (select project_id from project where
	 * p.project_parent_id=?) order by pt.project_task_id asc
	 */
	@Query("select pac from PlannedActualsCost pac join pac.projectTask pt join pt.project p"
			+ " where pac.costType = ?1 and p.projectId in("
			+ "  select pd.projectId from pt.project pd where p.projectParentId = ?2)" + " order by pt.projectTaskId asc")
	List<PlannedActualsCost> getPlannedAcutalsCostByProject(String costType, Integer projectParentId);
}
