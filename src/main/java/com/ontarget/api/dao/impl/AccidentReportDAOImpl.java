package com.ontarget.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.AccidentReportDAO;
import com.ontarget.bean.AccidentReport;
import com.ontarget.constant.OnTargetQuery;

@Repository
public class AccidentReportDAOImpl extends BaseGenericDAOImpl<AccidentReport>
		implements AccidentReportDAO {

	@Override
	public AccidentReport insert(AccidentReport accidentReport) {
		KeyHolder kh = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(
						OnTargetQuery.accidentReport.INSERT,
						new String[] { "accident_report_id" });
				ps.setString(1, accidentReport.getSubmittedTo());
				ps.setString(2, accidentReport.getSupervisorName());
				ps.setString(3, accidentReport.getWitness());
				ps.setString(4, accidentReport.getLocation());
				ps.setString(5, accidentReport.getBriefOfAccident());
				ps.setString(6, accidentReport.getSeverity());
				ps.setString(7, accidentReport.getDescription());
				ps.setString(8, accidentReport.getBodyPartAffected());
				ps.setDate(9, new java.sql.Date(accidentReport
						.getDateOfAccident().getTime()));
				ps.setString(10, accidentReport.getTimeOfAccident());
				ps.setString(11, accidentReport.getInjuredVisitedDoctor());
				ps.setString(12, accidentReport.getWorkersCompensationFiled());
				ps.setString(13, accidentReport.getInjuredLeftJob());
				if (accidentReport.getDateInjuredLeftJob() != null) {
					ps.setDate(14, new java.sql.Date(accidentReport
							.getDateInjuredLeftJob().getTime()));
				}
				ps.setString(15, accidentReport.getTimeInjuredLeftJob());
				ps.setString(16, accidentReport.getPossiblePreventiveMeasures());
				ps.setString(17, accidentReport.getUnsafeConditionsCorrected());
				ps.setString(18,
						accidentReport.getCorrectionMeasuresPerformed());
				ps.setString(19,
						accidentReport.getCorrectionMeasuresToBePerformed());
				ps.setLong(20, accidentReport.getProjectId());
				return ps;
			}

		}, kh);
		accidentReport.setAccidentReportId(kh.getKey().intValue());
		return accidentReport;
	}

	@Override
	public AccidentReport read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(AccidentReport accidentReport) {
		int count = jdbcTemplate.update(OnTargetQuery.accidentReport.UPDATE,
				accidentReport.getSubmittedTo(),
				accidentReport.getSupervisorName(),
				accidentReport.getWitness(), accidentReport.getLocation(),
				accidentReport.getBriefOfAccident(),
				accidentReport.getSeverity(), accidentReport.getDescription(),
				accidentReport.getBodyPartAffected(),
				accidentReport.getDateOfAccident(),
				accidentReport.getTimeOfAccident(),
				accidentReport.getInjuredVisitedDoctor(),
				accidentReport.getWorkersCompensationFiled(),
				accidentReport.getInjuredLeftJob(),
				accidentReport.getDateInjuredLeftJob(),
				accidentReport.getTimeInjuredLeftJob(),
				accidentReport.getPossiblePreventiveMeasures(),
				accidentReport.getUnsafeConditionsCorrected(),
				accidentReport.getCorrectionMeasuresPerformed(),
				accidentReport.getCorrectionMeasuresToBePerformed(),
				accidentReport.getAccidentReportId());
		return (count > 0);
	}

	@Override
	public List<AccidentReport> getAccidentReportsByProjectId(long projectId) {
		List<AccidentReport> accidentReports = jdbcTemplate.query(
				OnTargetQuery.accidentReport.GET_BY_PROJECT_ID,
				new Object[] { projectId }, new RowMapper<AccidentReport>() {

					@Override
					public AccidentReport mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						AccidentReport accidentReport = new AccidentReport();
						accidentReport.setAccidentReportId(rs
								.getInt("accident_report_id"));
						accidentReport.setSubmittedTo(rs
								.getString("submitted_to"));
						accidentReport.setSupervisorName(rs
								.getString("supervisor_name"));

						accidentReport.setWitness(rs.getString("witness"));

						accidentReport.setLocation(rs.getString("location"));

						accidentReport.setBriefOfAccident(rs
								.getString("brief_of_accident"));

						accidentReport.setSeverity(rs.getString("severity"));

						accidentReport.setDescription(rs
								.getString("description"));

						accidentReport.setBodyPartAffected(rs
								.getString("body_part_affected"));

						accidentReport.setDateOfAccident(rs
								.getDate("date_of_accident"));

						accidentReport.setTimeOfAccident(rs
								.getString("time_of_accident"));

						accidentReport.setInjuredVisitedDoctor(rs
								.getString("injured_visited_doctor"));

						accidentReport.setWorkersCompensationFiled(rs
								.getString("workers_compensation_filed"));

						accidentReport.setInjuredLeftJob(rs
								.getString("injured_left_job"));

						accidentReport.setDateInjuredLeftJob(rs
								.getDate("date_injured_left_job"));

						accidentReport.setTimeInjuredLeftJob(rs
								.getString("time_injured_left_job"));

						accidentReport.setPossiblePreventiveMeasures(rs
								.getString("possible_preventive_measures"));

						accidentReport.setUnsafeConditionsCorrected(rs
								.getString("unsafe_conditions_corrected"));

						accidentReport.setCorrectionMeasuresPerformed(rs
								.getString("correction_measures_performed"));

						accidentReport.setCorrectionMeasuresToBePerformed(rs
								.getString("correction_measures_to_be_performed"));

						return accidentReport;
					}

				});
		return accidentReports;
	}

}
