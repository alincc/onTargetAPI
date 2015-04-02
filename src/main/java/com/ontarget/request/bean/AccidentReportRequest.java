package com.ontarget.request.bean;

import java.sql.Date;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "projectId", "submittedTo",
		"supervisorName", "witness", "location", "briefOfAccident", "severity",
		"description", "bodyPartAffected", "dateOfAccident", "timeOfAccident",
		"injuredVisitedDoctor", "workersCompensationFiled", "injuredLeftJob",
		"dateInjuredLeftJob", "timeInjuredLeftJob",
		"possiblePreventiveMeasures", "unsafeConditionsCorrected",
		"correctionMeasuresPerformed", "correctionMeasuresToBePerformed" })
public class AccidentReportRequest {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@JsonProperty("projectId")
	private Integer projectId;
	@NotEmpty
	@JsonProperty("submittedTo")
	private String submittedTo;
	@NotEmpty
	@JsonProperty("supervisorName")
	private String supervisorName;
	@NotEmpty
	@JsonProperty("witness")
	private String witness;
	@NotEmpty
	@JsonProperty("location")
	private String location;
	@NotEmpty
	@JsonProperty("briefOfAccident")
	private String briefOfAccident;
	@NotEmpty
	@JsonProperty("severity")
	private String severity;
	@NotEmpty
	@JsonProperty("description")
	private String description;
	@NotEmpty
	@JsonProperty("bodyPartAffected")
	private String bodyPartAffected;
	@NotNull
	@JsonProperty("dateOfAccident")
	private Date dateOfAccident;
	@NotEmpty
	@JsonProperty("timeOfAccident")
	private String timeOfAccident;
	@NotEmpty
	@JsonProperty("injuredVisitedDoctor")
	private String injuredVisitedDoctor;
	@JsonProperty("workersCompensationFiled")
	private String workersCompensationFiled;
	@NotEmpty
	@JsonProperty("injuredLeftJob")
	private String injuredLeftJob;
	@JsonProperty("dateInjuredLeftJob")
	private Date dateInjuredLeftJob;
	@JsonProperty("timeInjuredLeftJob")
	private String timeInjuredLeftJob;
	@NotEmpty
	@JsonProperty("possiblePreventiveMeasures")
	private String possiblePreventiveMeasures;
	@NotEmpty
	@JsonProperty("unsafeConditionsCorrected")
	private String unsafeConditionsCorrected;
	@JsonProperty("correctionMeasuresPerformed")
	private String correctionMeasuresPerformed;
	@JsonProperty("correctionMeasuresToBePerformed")
	private String correctionMeasuresToBePerformed;

	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	@JsonProperty("projectId")
	public Integer getProjectId() {
		return projectId;
	}

	@JsonProperty("projectId")
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@JsonProperty("submittedTo")
	public String getSubmittedTo() {
		return submittedTo;
	}

	@JsonProperty("submittedTo")
	public void setSubmittedTo(String submittedTo) {
		this.submittedTo = submittedTo;
	}

	@JsonProperty("supervisorName")
	public String getSupervisorName() {
		return supervisorName;
	}

	@JsonProperty("supervisorName")
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	@JsonProperty("witness")
	public String getWitness() {
		return witness;
	}

	@JsonProperty("witness")
	public void setWitness(String witness) {
		this.witness = witness;
	}

	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

	@JsonProperty("briefOfAccident")
	public String getBriefOfAccident() {
		return briefOfAccident;
	}

	@JsonProperty("briefOfAccident")
	public void setBriefOfAccident(String briefOfAccident) {
		this.briefOfAccident = briefOfAccident;
	}

	@JsonProperty("severity")
	public String getSeverity() {
		return severity;
	}

	@JsonProperty("severity")
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("bodyPartAffected")
	public String getBodyPartAffected() {
		return bodyPartAffected;
	}

	@JsonProperty("bodyPartAffected")
	public void setBodyPartAffected(String bodyPartAffected) {
		this.bodyPartAffected = bodyPartAffected;
	}

	@JsonProperty("dateOfAccident")
	public Date getDateOfAccident() {
		return dateOfAccident;
	}

	@JsonProperty("dateOfAccident")
	public void setDateOfAccident(Date dateOfAccident) {
		this.dateOfAccident = dateOfAccident;
	}

	@JsonProperty("timeOfAccident")
	public String getTimeOfAccident() {
		return timeOfAccident;
	}

	@JsonProperty("timeOfAccident")
	public void setTimeOfAccident(String timeOfAccident) {
		this.timeOfAccident = timeOfAccident;
	}

	@JsonProperty("injuredVisitedDoctor")
	public String getInjuredVisitedDoctor() {
		return injuredVisitedDoctor;
	}

	@JsonProperty("injuredVisitedDoctor")
	public void setInjuredVisitedDoctor(String injuredVisitedDoctor) {
		this.injuredVisitedDoctor = injuredVisitedDoctor;
	}

	@JsonProperty("workersCompensationFiled")
	public String getWorkersCompensationFiled() {
		return workersCompensationFiled;
	}

	@JsonProperty("workersCompensationFiled")
	public void setWorkersCompensationFiled(String workersCompensationFiled) {
		this.workersCompensationFiled = workersCompensationFiled;
	}

	@JsonProperty("injuredLeftJob")
	public String getInjuredLeftJob() {
		return injuredLeftJob;
	}

	@JsonProperty("injuredLeftJob")
	public void setInjuredLeftJob(String injuredLeftJob) {
		this.injuredLeftJob = injuredLeftJob;
	}

	@JsonProperty("dateInjuredLeftJob")
	public Date getDateInjuredLeftJob() {
		return dateInjuredLeftJob;
	}

	@JsonProperty("dateInjuredLeftJob")
	public void setDateInjuredLeftJob(Date dateInjuredLeftJob) {
		this.dateInjuredLeftJob = dateInjuredLeftJob;
	}

	@JsonProperty("timeInjuredLeftJob")
	public String getTimeInjuredLeftJob() {
		return timeInjuredLeftJob;
	}

	@JsonProperty("timeInjuredLeftJob")
	public void setTimeInjuredLeftJob(String timeInjuredLeftJob) {
		this.timeInjuredLeftJob = timeInjuredLeftJob;
	}

	@JsonProperty("possiblePreventiveMeasures")
	public String getPossiblePreventiveMeasures() {
		return possiblePreventiveMeasures;
	}

	@JsonProperty("possiblePreventiveMeasures")
	public void setPossiblePreventiveMeasures(String possiblePreventiveMeasures) {
		this.possiblePreventiveMeasures = possiblePreventiveMeasures;
	}

	@JsonProperty("unsafeConditionsCorrected")
	public String getUnsafeConditionsCorrected() {
		return unsafeConditionsCorrected;
	}

	@JsonProperty("unsafeConditionsCorrected")
	public void setUnsafeConditionsCorrected(String unsafeConditionsCorrected) {
		this.unsafeConditionsCorrected = unsafeConditionsCorrected;
	}

	@JsonProperty("correctionMeasuresPerformed")
	public String getCorrectionMeasuresPerformed() {
		return correctionMeasuresPerformed;
	}

	@JsonProperty("correctionMeasuresPerformed")
	public void setCorrectionMeasuresPerformed(
			String correctionMeasuresPerformed) {
		this.correctionMeasuresPerformed = correctionMeasuresPerformed;
	}

	@JsonProperty("correctionMeasuresToBePerformed")
	public String getCorrectionMeasuresToBePerformed() {
		return correctionMeasuresToBePerformed;
	}

	@JsonProperty("correctionMeasuresToBePerformed")
	public void setCorrectionMeasuresToBePerformed(
			String correctionMeasuresToBePerformed) {
		this.correctionMeasuresToBePerformed = correctionMeasuresToBePerformed;
	}

}
