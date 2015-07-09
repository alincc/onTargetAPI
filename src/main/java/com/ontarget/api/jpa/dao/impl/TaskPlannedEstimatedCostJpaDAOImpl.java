package com.ontarget.api.jpa.dao.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.TaskEstimatedCostDAO;
import com.ontarget.api.repository.PlannedActualsCostRepository;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.entities.PlannedActualsCost;
import com.ontarget.entities.ProjectTask;
import com.ontarget.entities.User;
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
		plannedActualsCost.setCreatedBy(new User(cost.getCreatedBy()));
		plannedActualsCost.setCreatedDate(new Date());
		plannedActualsCostRepository.save(plannedActualsCost);

		return plannedActualsCost.getId();
	}

	@Override
	public boolean updatePlannedActualCost(TaskEstimatedCost cost) throws Exception {
		PlannedActualsCost plannedActualsCost = plannedActualsCostRepository.findById(cost.getId());

		plannedActualsCost.setModifiedBy(new User(cost.getModifiedBy()));
		plannedActualsCost.setModifiedDate(new Date());
		plannedActualsCost.setValue(new BigDecimal(cost.getCost()));
		plannedActualsCostRepository.save(plannedActualsCost);

		return true;
	}

}
