package com.ontarget.api.jpa.dao.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.TaskEstimatedCostDAO;
import com.ontarget.api.repository.PlannedActualsCostRepository;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.entities.PlannedActualsCost;
import com.ontarget.entities.ProjectTask;
import com.ontarget.util.DateFormater;

@Repository("taskPlannedEstimatedCostJpaDAOImpl")
public class TaskPlannedEstimatedCostJpaDAOImpl implements TaskEstimatedCostDAO {
	@Resource
	private PlannedActualsCostRepository plannedActualsCostRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int addPlannedAcutalCost(TaskEstimatedCost cost) throws Exception {
		PlannedActualsCost plannedActualsCost = new PlannedActualsCost();
		plannedActualsCost.setProjectTask(new ProjectTask(cost.getTaskId()));
		plannedActualsCost.setFromDate(cost.getFromDate());
		plannedActualsCost.setToDate(cost.getToDate());
		plannedActualsCost.setCostType(cost.getCostType());
		plannedActualsCost.setValue(new BigDecimal(cost.getCost()));
		plannedActualsCost.setExpiryDate(DateFormater.convertToDate("9999-12-31"));
		plannedActualsCost.setCreatedBy(cost.getCreatedBy());
		plannedActualsCost.setCreatedDate(new Date());
		plannedActualsCost.setModifiedBy(cost.getModifiedBy());
		plannedActualsCost.setModifiedDate(new Date());
		plannedActualsCostRepository.save(plannedActualsCost);

		return plannedActualsCost.getId();
	}

	@Override
	public boolean updatePlannedActualCost(TaskEstimatedCost cost) throws Exception {
		String hql = "update PlannedActualsCost p set p.value = :value,"
				+ " p.modifiedBy = :modifiedBy, p.modifiedDate = :modifiedDate where p.id = :id";

		Query query = entityManager.createQuery(hql);
		query.setParameter("value", new BigDecimal(cost.getCost()));
		query.setParameter("modifiedBy", cost.getModifiedBy());
		query.setParameter("modifiedDate", new Date());
		query.setParameter("id", cost.getId());
		query.executeUpdate();

		return true;
	}

}
