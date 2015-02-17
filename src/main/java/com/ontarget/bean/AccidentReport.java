package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;

import com.ontarget.dto.BaseRequestDTO;

public class AccidentReport implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer accidentReportId;
	//private ProjectDTO project;
	private Integer projectId;
	private String submittedTo;
	private String supervisorName;
	private String witness;
	private String location;
	private String briefOfAccident;
	private String severity;
	private String description;
	private String bodyPartAffected;
	private Date dateOfAccident;
	private String timeOfAccident;
	private String injuredVisitedDoctor;
	private String workersCompensationFiled;
	private String injuredLeftJob;
	private Date dateInjuredLeftJob;
	private String timeInjuredLeftJob;
	private String possiblePreventiveMeasures;
	private String unsafeConditionsCorrected;
	private String correctionMeasuresPerformed;
	private String correctionMeasuresToBePerformed;
	private String username;
	private Integer userId;

	// public ProjectDTO getProject() {
	// return project;
	// }
	//
	// public void setProject(ProjectDTO project) {
	// this.project = project;
	// }

	public String getSubmittedTo() {
		return submittedTo;
	}

	public void setSubmittedTo(String submittedTo) {
		this.submittedTo = submittedTo;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public String getWitness() {
		return witness;
	}

	public void setWitness(String witness) {
		this.witness = witness;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBriefOfAccident() {
		return briefOfAccident;
	}

	public void setBriefOfAccident(String briefOfAccident) {
		this.briefOfAccident = briefOfAccident;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBodyPartAffected() {
		return bodyPartAffected;
	}

	public void setBodyPartAffected(String bodyPartAffected) {
		this.bodyPartAffected = bodyPartAffected;
	}

	public Date getDateOfAccident() {
		return dateOfAccident;
	}

	public void setDateOfAccident(Date dateOfAccident) {
		this.dateOfAccident = dateOfAccident;
	}

	public String getTimeOfAccident() {
		return timeOfAccident;
	}

	public void setTimeOfAccident(String timeOfAccident) {
		this.timeOfAccident = timeOfAccident;
	}

	public String getInjuredVisitedDoctor() {
		return injuredVisitedDoctor;
	}

	public void setInjuredVisitedDoctor(String injuredVisitedDoctor) {
		this.injuredVisitedDoctor = injuredVisitedDoctor;
	}

	public String getWorkersCompensationFiled() {
		return workersCompensationFiled;
	}

	public void setWorkersCompensationFiled(String workersCompensationFiled) {
		this.workersCompensationFiled = workersCompensationFiled;
	}

	public String getInjuredLeftJob() {
		return injuredLeftJob;
	}

	public void setInjuredLeftJob(String injuredLeftJob) {
		this.injuredLeftJob = injuredLeftJob;
	}

	public Date getDateInjuredLeftJob() {
		return dateInjuredLeftJob;
	}

	public void setDateInjuredLeftJob(Date dateInjuredLeftJob) {
		this.dateInjuredLeftJob = dateInjuredLeftJob;
	}

	public String getTimeInjuredLeftJob() {
		return timeInjuredLeftJob;
	}

	public void setTimeInjuredLeftJob(String timeInjuredLeftJob) {
		this.timeInjuredLeftJob = timeInjuredLeftJob;
	}

	public String getPossiblePreventiveMeasures() {
		return possiblePreventiveMeasures;
	}

	public void setPossiblePreventiveMeasures(String possiblePreventiveMeasures) {
		this.possiblePreventiveMeasures = possiblePreventiveMeasures;
	}

	public String getUnsafeConditionsCorrected() {
		return unsafeConditionsCorrected;
	}

	public void setUnsafeConditionsCorrected(String unsafeConditionsCorrected) {
		this.unsafeConditionsCorrected = unsafeConditionsCorrected;
	}

	public String getCorrectionMeasuresPerformed() {
		return correctionMeasuresPerformed;
	}

	public void setCorrectionMeasuresPerformed(
			String correctionMeasuresPerformed) {
		this.correctionMeasuresPerformed = correctionMeasuresPerformed;
	}

	public String getCorrectionMeasuresToBePerformed() {
		return correctionMeasuresToBePerformed;
	}

	public void setCorrectionMeasuresToBePerformed(
			String correctionMeasuresToBePerformed) {
		this.correctionMeasuresToBePerformed = correctionMeasuresToBePerformed;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAccidentReportId() {
		return accidentReportId;
	}

	public void setAccidentReportId(Integer accidentReportId) {
		this.accidentReportId = accidentReportId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
