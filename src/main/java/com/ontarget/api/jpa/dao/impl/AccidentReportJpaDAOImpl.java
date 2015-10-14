package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.AccidentReportDAO;
import com.ontarget.api.repository.AccidentReportRepository;
import com.ontarget.bean.AccidentReport;

@Repository("accidentReportJpaDAOImpl")
public class AccidentReportJpaDAOImpl implements AccidentReportDAO {
	@Resource
	private AccidentReportRepository accidentReportRepository;

	@Override
	public AccidentReport insert(AccidentReport report) {
		com.ontarget.entities.AccidentReport accidentReport = new com.ontarget.entities.AccidentReport();
		accidentReport.setSubmittedTo(report.getSubmittedTo());
		accidentReport.setSupervisorName(report.getSupervisorName());
		accidentReport.setWitness(report.getWitness());
		accidentReport.setLocation(report.getLocation());
		accidentReport.setBriefOfAccident(report.getBriefOfAccident());
		accidentReport.setSeverity(report.getSeverity());
		accidentReport.setDescription(report.getDescription());
		accidentReport.setBodyPartAffected(report.getBodyPartAffected());
		accidentReport.setDateOfAccident(report.getDateOfAccident());
		accidentReport.setTimeOfAccident(report.getTimeOfAccident());
		accidentReport.setInjuredVisitedDoctor(report.getInjuredVisitedDoctor());
		accidentReport.setWorkersCompensationFiled(report.getWorkersCompensationFiled());
		accidentReport.setInjuredLeftJob(report.getInjuredLeftJob());
		if (report.getDateInjuredLeftJob() != null) {
			accidentReport.setDateInjuredLeftJob(report.getDateInjuredLeftJob());
		}
		accidentReport.setTimeInjuredLeftJob(report.getTimeInjuredLeftJob());
		accidentReport.setPossiblePreventiveMeasures(report.getPossiblePreventiveMeasures());
		accidentReport.setUnsafeConditionsCorrected(report.getUnsafeConditionsCorrected());
		accidentReport.setCorrectionMeasuresPerformed(report.getCorrectionMeasuresPerformed());
		accidentReport.setCorrectionMeasuresToBePerformed(report.getCorrectionMeasuresToBePerformed());
		accidentReport.setProjectId(report.getProjectId());
		accidentReportRepository.save(accidentReport);

		report.setAccidentReportId(accidentReport.getAccidentReportId());
		return report;
	}

	@Override
	public AccidentReport read(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(AccidentReport report) {
		com.ontarget.entities.AccidentReport accidentReport = accidentReportRepository.findOne(report.getAccidentReportId());
		accidentReport.setSubmittedTo(report.getSubmittedTo());
		accidentReport.setSupervisorName(report.getSupervisorName());
		accidentReport.setWitness(report.getWitness());
		accidentReport.setLocation(report.getLocation());
		accidentReport.setBriefOfAccident(report.getBriefOfAccident());
		accidentReport.setSeverity(report.getSeverity());
		accidentReport.setDescription(report.getDescription());
		accidentReport.setBodyPartAffected(report.getBodyPartAffected());
		accidentReport.setDateOfAccident(report.getDateOfAccident());
		accidentReport.setTimeOfAccident(report.getTimeOfAccident());
		accidentReport.setInjuredVisitedDoctor(report.getInjuredVisitedDoctor());
		accidentReport.setWorkersCompensationFiled(report.getWorkersCompensationFiled());
		accidentReport.setInjuredLeftJob(report.getInjuredLeftJob());
		if (report.getDateInjuredLeftJob() != null) {
			accidentReport.setDateInjuredLeftJob(report.getDateInjuredLeftJob());
		}
		accidentReport.setTimeInjuredLeftJob(report.getTimeInjuredLeftJob());
		accidentReport.setPossiblePreventiveMeasures(report.getPossiblePreventiveMeasures());
		accidentReport.setUnsafeConditionsCorrected(report.getUnsafeConditionsCorrected());
		accidentReport.setCorrectionMeasuresPerformed(report.getCorrectionMeasuresPerformed());
		accidentReport.setCorrectionMeasuresToBePerformed(report.getCorrectionMeasuresToBePerformed());

		accidentReportRepository.save(accidentReport);

		return true;
	}

	@Override
	public List<AccidentReport> getAccidentReportsByProjectId(long projectId) {
		List<AccidentReport> accidentReports = new ArrayList<>();
		List<com.ontarget.entities.AccidentReport> reports = accidentReportRepository
				.findByProjectIdOrderByAccidentReportIdDesc((int) projectId);

		if (reports != null && !reports.isEmpty()) {
			for (com.ontarget.entities.AccidentReport report : reports) {
				AccidentReport accidentReport = new AccidentReport();
				accidentReport.setAccidentReportId(report.getAccidentReportId());
				accidentReport.setSubmittedTo(report.getSubmittedTo());
				accidentReport.setSupervisorName(report.getSupervisorName());
				accidentReport.setWitness(report.getWitness());
				accidentReport.setLocation(report.getLocation());
				accidentReport.setBriefOfAccident(report.getBriefOfAccident());
				accidentReport.setSeverity(report.getSeverity());
				accidentReport.setDescription(report.getDescription());
				accidentReport.setBodyPartAffected(report.getBodyPartAffected());
				accidentReport.setDateOfAccident(report.getDateOfAccident());
				accidentReport.setTimeOfAccident(report.getTimeOfAccident());
				accidentReport.setInjuredVisitedDoctor(report.getInjuredVisitedDoctor());
				accidentReport.setWorkersCompensationFiled(report.getWorkersCompensationFiled());
				accidentReport.setInjuredLeftJob(report.getInjuredLeftJob());
				accidentReport.setDateInjuredLeftJob(report.getDateInjuredLeftJob());
				accidentReport.setTimeInjuredLeftJob(report.getTimeInjuredLeftJob());
				accidentReport.setPossiblePreventiveMeasures(report.getPossiblePreventiveMeasures());
				accidentReport.setUnsafeConditionsCorrected(report.getUnsafeConditionsCorrected());
				accidentReport.setCorrectionMeasuresPerformed(report.getCorrectionMeasuresPerformed());
				accidentReport.setCorrectionMeasuresToBePerformed(report.getCorrectionMeasuresToBePerformed());
				accidentReports.add(accidentReport);
			}
		}
		return accidentReports;
	}

}
