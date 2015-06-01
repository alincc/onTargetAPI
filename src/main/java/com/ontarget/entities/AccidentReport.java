package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "accident_report")
public class AccidentReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accident_report_id", nullable = false)
    private Integer accidentReportId;
    @Basic(optional = false)
    @Column(name = "project_id", nullable = false)
    private int projectId;
    @Column(name = "submitted_to", length = 45)
    private String submittedTo;
    @Column(name = "supervisor_name", length = 45)
    private String supervisorName;
    @Column(name = "witness", length = 45)
    private String witness;
    @Column(name = "location", length = 45)
    private String location;
    @Column(name = "brief_of_accident", length = 45)
    private String briefOfAccident;
    @Column(name = "severity", length = 45)
    private String severity;
    @Column(name = "description", length = 45)
    private String description;
    @Column(name = "body_part_affected", length = 45)
    private String bodyPartAffected;
    @Column(name = "date_of_accident")
    @Temporal(TemporalType.DATE)
    private Date dateOfAccident;
    @Column(name = "time_of_accident", length = 45)
    private String timeOfAccident;
    @Column(name = "injured_visited_doctor", length = 3)
    private String injuredVisitedDoctor;
    @Column(name = "workers_compensation_filed", length = 3)
    private String workersCompensationFiled;
    @Column(name = "injured_left_job", length = 3)
    private String injuredLeftJob;
    @Column(name = "date_injured_left_job")
    @Temporal(TemporalType.DATE)
    private Date dateInjuredLeftJob;
    @Column(name = "time_injured_left_job", length = 45)
    private String timeInjuredLeftJob;
    @Column(name = "possible_preventive_measures", length = 45)
    private String possiblePreventiveMeasures;
    @Column(name = "unsafe_conditions_corrected", length = 3)
    private String unsafeConditionsCorrected;
    @Column(name = "correction_measures_performed", length = 45)
    private String correctionMeasuresPerformed;
    @Column(name = "correction_measures_to_be_performed", length = 45)
    private String correctionMeasuresToBePerformed;

    public AccidentReport() {
    }

    public AccidentReport(Integer accidentReportId) {
        this.accidentReportId = accidentReportId;
    }

    public AccidentReport(Integer accidentReportId, int projectId) {
        this.accidentReportId = accidentReportId;
        this.projectId = projectId;
    }

    public Integer getAccidentReportId() {
        return accidentReportId;
    }

    public void setAccidentReportId(Integer accidentReportId) {
        this.accidentReportId = accidentReportId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

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

    public void setCorrectionMeasuresPerformed(String correctionMeasuresPerformed) {
        this.correctionMeasuresPerformed = correctionMeasuresPerformed;
    }

    public String getCorrectionMeasuresToBePerformed() {
        return correctionMeasuresToBePerformed;
    }

    public void setCorrectionMeasuresToBePerformed(String correctionMeasuresToBePerformed) {
        this.correctionMeasuresToBePerformed = correctionMeasuresToBePerformed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accidentReportId != null ? accidentReportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccidentReport)) {
            return false;
        }
        AccidentReport other = (AccidentReport) object;
        if ((this.accidentReportId == null && other.accidentReportId != null) || (this.accidentReportId != null && !this.accidentReportId.equals(other.accidentReportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ontarget.entities.AccidentReport[accidentReportId=" + accidentReportId + "]";
    }

}
