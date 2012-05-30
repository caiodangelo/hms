package com.uff.hmstpa.model.persistence.impl;

import com.uff.hmstpa.controller.impl.ScheduleSystemControllerImpl;
import com.uff.hmstpa.model.domain.valueobject.Appointment;
import com.uff.hmstpa.model.persistence.AbstractModelDAO;
import com.uff.hmstpa.model.persistence.AppointmentDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.jdbc.core.RowMapper;

public class AppointmentDAOImpl extends AbstractModelDAO implements AppointmentDAO {

	private static AppointmentDAOImpl SOLE_INSTANCE;

	private AppointmentDAOImpl() {
		super();
	}

	public static AppointmentDAO getInstance() {
		if (SOLE_INSTANCE == null) {
			SOLE_INSTANCE = new AppointmentDAOImpl();
		}
		return SOLE_INSTANCE;
	}

	public void persist(String crm, String cpf, DateTime time) {
		String timeString = parseDate(time);
		String sql = "INSERT INTO appointment(doctor, patient, time) VALUE (?, ?, ?)";
		Object[] params = new Object[]{crm, cpf, timeString};
		jdbcTemplate.update(sql, params);
	}

	public List<Appointment> loadAppointments(String doctorCRM) {
		return jdbcTemplate.query("SELECT * FROM appointment WHERE doctor = ?", new Object[]{doctorCRM}, new AppointmentMapper());
	}

	public List<Appointment> loadAllAppointments() {
		return jdbcTemplate.query("SELECT * FROM appointment", new AppointmentMapper());
	}

	public void delete(String crm, String cpf, DateTime time) {
		String sql = "DELETE FROM appointment WHERE doctor = ? AND patient = ? AND time = ?";
		Object[] params = new Object[]{crm, cpf, time};
		jdbcTemplate.update(sql, params);
	}

	public Appointment retrieve(String crm, String cpf, DateTime time) {
		String timeString = parseDate(time);
		
		try {
  			String sql = "SELECT * FROM appointment WHERE doctor = ? AND patient = ? AND time = ?";
			Object[] params = new Object[]{crm, cpf, timeString};
			return jdbcTemplate.queryForObject(sql, params, new AppointmentMapper());
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	private static final class AppointmentMapper implements RowMapper<Appointment> {

		public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Appointment appointment = new Appointment();
			appointment.setDoctor(DoctorDAOImpl.getInstance().retrieve(rs.getString("doctor")));
			appointment.setPatient(PatientDAOImpl.getInstance().retrieve(rs.getString("patient")));
			appointment.setTime(new DateTime(rs.getDate("time").getTime()));
			return appointment;
		}
	}
	
	private static String parseDate(DateTime time) {
		DateFormatter df = new DateFormatter("yyyy-MM-dd hh:mm");
		return df.print(time.toDate(), Locale.getDefault());
	}
}
